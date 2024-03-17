package work.socialhub.kmisskey.api.response.other

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class ServiceWorkerRegisterResponse {
    var state: String? = null
    var key: String? = null
}


