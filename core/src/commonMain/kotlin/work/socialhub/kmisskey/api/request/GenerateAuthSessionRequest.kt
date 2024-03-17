package work.socialhub.kmisskey.api.request

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class GenerateAuthSessionRequest {

    var appSecret: String? = null
}


