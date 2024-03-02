package misskey4j.entity

import kotlinx.serialization.Serializable

@Serializable
class AvatarDecoration {

    lateinit var id: String
    var angle: Float? = null
    var flipH: Boolean = false
    lateinit var url: String
    var offsetX: Float? = null
    var offsetY: Float? = null
}