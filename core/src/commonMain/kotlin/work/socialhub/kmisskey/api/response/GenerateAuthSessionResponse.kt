package work.socialhub.kmisskey.api.response

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class GenerateAuthSessionResponse {
    var token: String? = null
    var url: String? = null
}
