package work.socialhub.kmisskey.api.request

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class UserKeyAuthSessionRequest {

    var appSecret: String? = null
    var token: String? = null
}
