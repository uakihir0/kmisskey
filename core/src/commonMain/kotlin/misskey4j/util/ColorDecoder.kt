package misskey4j.util

import misskey4j.entity.Color

object ColorDecoder {

    /**
     * Decode color string to Color object.
     */
    fun decode(color: String) : Color {

        // #RRGGBB
        if (color.startsWith("#")) {
            val hex = color.replace("#", "")
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
                .replace(")", "").
                split(",")
            val r = rgb[0].toInt()
            val g = rgb[1].toInt()
            val b = rgb[2].toInt()
            return Color().apply {
                this.r = r
                this.g = g
                this.b = b
            }
        }

        // R,G,B
        val rgb = color.split(",")
        val r = rgb[0].toInt()
        val g = rgb[1].toInt()
        val b = rgb[2].toInt()
        return Color().apply {
            this.r = r
            this.g = g
            this.b = b
        }
    }
}