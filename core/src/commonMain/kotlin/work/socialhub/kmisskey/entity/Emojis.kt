package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.util.json.EmojisSerializer
import kotlin.js.JsExport

@JsExport
@Serializable(with = EmojisSerializer::class)
open class Emojis {
    var list: Array<Emoji> = arrayOf()
}
