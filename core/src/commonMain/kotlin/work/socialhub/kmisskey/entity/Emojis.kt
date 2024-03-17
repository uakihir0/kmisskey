package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
open class Emojis {
    var list: Array<Emoji> = arrayOf()
}
