package work.socialhub.kmisskey.api.request.other

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class ServiceWorkerRegisterRequest : TokenRequest() {

    var endpoint: String? = null
    var auth: String? = null
    var publickey: String? = null
}
