package work.socialhub.kmisskey.util

import work.socialhub.kmisskey.entity.Color

object ColorDecoder {

    /**
     * Decode color string to Color object.
     */
    fun decode(color: String): Color {

        // #RRGGBB または RRGGBB (6文字の16進数)
        if (color.startsWith("#") || (color.length == 6 && color.all { it.isHexDigit() })) {
            val hex = color.removePrefix("#")
            val r = hex.substring(0, 2).toInt(16)
            val g = hex.substring(2, 4).toInt(16)
            val b = hex.substring(4, 6).toInt(16)
            return Color().apply {
                this.r = r
                this.g = g
                this.b = b
            }
        }

        // rgb(R, G, B)
        if (color.startsWith("rgb")) {
            val rgb = color
                .replace("rgb(", "")
                .replace(")", "").split(",")
            val r = rgb[0].trim().toInt()
            val g = rgb[1].trim().toInt()
            val b = rgb[2].trim().toInt()
            return Color().apply {
                this.r = r
                this.g = g
                this.b = b
            }
        }

        // R,G,B
        val rgb = color.split(",")
        val r = rgb[0].trim().toInt()
        val g = rgb[1].trim().toInt()
        val b = rgb[2].trim().toInt()
        return Color().apply {
            this.r = r
            this.g = g
            this.b = b
        }
    }

    /**
     * 文字が16進数の文字かどうかを判定する
     */
    private fun Char.isHexDigit(): Boolean {
        return this in '0'..'9' || this in 'a'..'f' || this in 'A'..'F'
    }
}