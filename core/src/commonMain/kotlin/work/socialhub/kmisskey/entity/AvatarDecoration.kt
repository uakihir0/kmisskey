package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class AvatarDecoration {

    lateinit var id: String
    var angle: Float? = null
    var flipH: Boolean = false
    lateinit var url: String
    var offsetX: Float? = null
    var offsetY: Float? = null
}