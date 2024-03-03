package work.socialhub.kmisskey.util

import kotlin.math.*

/**
 * BlueHash Decoder*
 * by wolt (see https://github.com/woltapp/blurhash/issues/95)
 */
class BlurHashDecoder private constructor() {

    // cache Math.cos() calculations to improve performance.
    // The number of calculations can be huge for many bitmaps: width * height * numCompX * numCompY * 2 * nBitmaps
    // the cache is enabled by default, it is recommended to disable it only when just a few images are displayed
    private val cacheCosinesX = mutableMapOf<Int, DoubleArray>()
    private val cacheCosinesY = mutableMapOf<Int, DoubleArray>()

    /**
     * Clear calculations stored in memory cache.
     * The cache is not big, but will increase when many image sizes are used,
     * if the app needs memory it is recommended to clear it.
     */
    private fun clearCache() {
        cacheCosinesX.clear()
        cacheCosinesY.clear()
    }

    /**
     * Decode a blur hash into a new bitmap.
     *
     * @param useCache use in memory cache for the calculated math, reused by images with same size.
     * if the cache does not exist yet it will be created and populated with new calculations.
     * By default it is true.
     */
    fun decode(
        blurHash: String?,
        width: Int,
        height: Int,
        punch: Float,
        useCache: Boolean
    ): Array<Array<IntArray>>? {

        if (blurHash == null || blurHash.length <= 6) {
            return null
        }

        val numCompEnc = decode83(blurHash, 0, 1)
        val numCompX = numCompEnc % 9 + 1
        val numCompY = numCompEnc / 9 + 1

        if (blurHash.length != 4 + 2 * numCompX * numCompY) {
            return null
        } else {
            val maxAcEnc = this.decode83(blurHash, 1, 2)
            val maxAc = (maxAcEnc + 1).toFloat() / 166.0f
            val colors = arrayOfNulls<FloatArray>(numCompX * numCompY)

            for (i in 0 until numCompX * numCompY) {
                if (i == 0) {
                    val colorEnc = decode83(blurHash, 2, 6)
                    colors[i] = decodeDc(colorEnc)
                } else {
                    val from = 4 + i * 2
                    val colorEnc = decode83(blurHash, from, from + 2)
                    colors[i] = decodeAc(colorEnc, maxAc * punch)
                }
            }
            return composeBitmap(
                width,
                height,
                numCompX,
                numCompY,
                colors,
                useCache,
            )
        }
    }

    private fun decode83(
        str: String,
        from: Int,
        to: Int
    ): Int {

        var result = 0
        for (i in from until to) {
            val index = charMap[str[i]]!!
            if (index != -1) {
                result = result * 83 + index
            }
        }
        return result
    }


    private fun decodeDc(
        colorEnc: Int
    ): FloatArray {
        val r = colorEnc shr 16
        val g = colorEnc shr 8 and 255
        val b = colorEnc and 255
        return floatArrayOf(
            sRGBToLinear(r.toDouble()),
            sRGBToLinear(g.toDouble()),
            sRGBToLinear(b.toDouble())
        )
    }

    private fun sRGBToLinear(colorEnc: Double): Float {
        val v = colorEnc.toFloat() / 255.0f
        return if (v <= 0.04045f) {
            v / 12.92f
        } else {
            ((v + 0.055f) / 1.055f)
                .toDouble()
                .pow(2.4)
                .toFloat()
        }
    }

    private fun decodeAc(
        value: Int,
        maxAc: Float
    ): FloatArray {

        val r = value / 361
        val g = (value / 19) % 19
        val b = value % 19
        return floatArrayOf(
            signedPow2((r - 9) / 9.0f) * maxAc,
            signedPow2((g - 9) / 9.0f) * maxAc,
            signedPow2((b - 9) / 9.0f) * maxAc
        )
    }

    private fun signedPow2(value: Float): Float {
        return (value.toDouble().pow(2.0))
            .withSign(value.toDouble())
            .toFloat()
    }

    private fun composeBitmap(
        width: Int,
        height: Int,
        numCompX: Int,
        numCompY: Int,
        colors: Array<FloatArray?>,
        useCache: Boolean
    ): Array<Array<IntArray>> {

        // use an array for better performance when writing pixel colors
        val imageArray = Array(width) { Array(height) { IntArray(3) } }
        val calculateCosX = !useCache || !cacheCosinesX.containsKey(width * numCompX)
        val cosinesX = getArrayForCosinesX(calculateCosX, width, numCompX)
        val calculateCosY = !useCache || !cacheCosinesY.containsKey(height * numCompY)
        val cosinesY = getArrayForCosinesY(calculateCosY, height, numCompY)
        for (y in 0 until height) {
            for (x in 0 until width) {
                var r = 0.0f
                var g = 0.0f
                var b = 0.0f
                for (j in 0 until numCompY) {
                    for (i in 0 until numCompX) {
                        val cosX = getCos(cosinesX, calculateCosX, i, numCompX, x, width)
                        val cosY = getCos(cosinesY, calculateCosY, j, numCompY, y, height)
                        val basis = (cosX * cosY).toFloat()
                        val color = colors[j * numCompX + i]
                        r += color!![0] * basis
                        g += color[1] * basis
                        b += color[2] * basis
                    }
                }

                imageArray[x][y][0] = linearToSRGB(r.toDouble())
                imageArray[x][y][1] = linearToSRGB(g.toDouble())
                imageArray[x][y][2] = linearToSRGB(b.toDouble())
            }
        }
        return imageArray
    }

    private fun getArrayForCosinesY(
        calculate: Boolean,
        height: Int,
        numCompY: Int,
    ): DoubleArray {

        if (calculate) {
            val cosinesY = DoubleArray(height * numCompY)
            cacheCosinesY[height * numCompY] = cosinesY
            return cosinesY
        } else {
            return cacheCosinesY[height * numCompY]!!
        }
    }

    private fun getArrayForCosinesX(
        calculate: Boolean,
        width: Int,
        numCompX: Int,
    ): DoubleArray {

        if (calculate) {
            val cosinesX = DoubleArray(width * numCompX)
            cacheCosinesX[width * numCompX] = cosinesX
            return cosinesX
        } else {
            return cacheCosinesX[width * numCompX]!!
        }
    }

    private fun getCos(
        getCos: DoubleArray,
        calculate: Boolean,
        x: Int,
        numComp: Int,
        y: Int,
        size: Int,
    ): Double {

        if (calculate) {
            getCos[x + numComp * y] = cos(PI * y * x / size)
        }
        return getCos[x + numComp * y]
    }

    private fun linearToSRGB(value: Double): Int {
        val v = max(0.0, min(1.0, value))
        return if (v <= 0.0031308f) {
            (v * 12.92f * 255.0f + 0.5f).toInt()
        } else {
            ((1.055f * v.pow((1 / 2.4f).toDouble()) - 0.055f) * 255 + 0.5f).toInt()
        }
    }

    companion object {
        val instance = BlurHashDecoder()
        private val charMap = mutableMapOf<Char, Int>()

        init {
            val characters = arrayOf(
                '0',
                '1',
                '2',
                '3',
                '4',
                '5',
                '6',
                '7',
                '8',
                '9',
                'A',
                'B',
                'C',
                'D',
                'E',
                'F',
                'G',
                'H',
                'I',
                'J',
                'K',
                'L',
                'M',
                'N',
                'O',
                'P',
                'Q',
                'R',
                'S',
                'T',
                'U',
                'V',
                'W',
                'X',
                'Y',
                'Z',
                'a',
                'b',
                'c',
                'd',
                'e',
                'f',
                'g',
                'h',
                'i',
                'j',
                'k',
                'l',
                'm',
                'n',
                'o',
                'p',
                'q',
                'r',
                's',
                't',
                'u',
                'v',
                'w',
                'x',
                'y',
                'z',
                '#',
                '$',
                '%',
                '*',
                '+',
                ',',
                '-',
                '.',
                ':',
                ';',
                '=',
                '?',
                '@',
                '[',
                ']',
                '^',
                '_',
                '{',
                '|',
                '}',
                '~'
            )
            for (i in characters.indices) {
                charMap[characters[i]] = i
            }
        }
    }
}
