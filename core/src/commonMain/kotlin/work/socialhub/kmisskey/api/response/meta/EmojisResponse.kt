package work.socialhub.kmisskey.api.response.meta

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.Emoji
import kotlin.js.JsExport

@JsExport
@Serializable
class EmojisResponse {
    var emojis: Array<Emoji> = arrayOf()
}
