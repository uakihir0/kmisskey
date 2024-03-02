package misskey4j.api.request.other

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class ServiceWorkerRegisterRequest : TokenRequest() {

    var endpoint: String? = null
    var auth: String? = null
    var publickey: String? = null
}
