package work.socialhub.kmisskey.api.response.other

import kotlinx.serialization.Serializable

@Serializable
class ServiceWorkerRegisterResponse {
    var state: String? = null
    var key: String? = null
}


