package work.socialhub.kmisskey.api.model

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class PollRequest {
    var choices: Array<String>? = null
    var multiple: Boolean? = null
    var expiresAt: Int? = null
    var expiredAfter: Int? = null
}
