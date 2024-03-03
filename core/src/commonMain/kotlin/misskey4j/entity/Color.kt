package misskey4j.entity

import kotlinx.serialization.Serializable

@Serializable
class Color {
    var r = 0
    var g = 0
    var b = 0

    override fun toString(): String {
        return "Color(r=$r, g=$g, b=$b)"
    }
}
