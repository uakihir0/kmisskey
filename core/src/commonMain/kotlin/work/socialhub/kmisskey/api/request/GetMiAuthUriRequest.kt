package work.socialhub.kmisskey.api.request

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class GetMiAuthUriRequest {

    var sessionId: String? = null
    var name: String? = null
    var iconUri: String? = null
    var callbackUrl: String? = null
    var permission: Array<String>? = null
}
