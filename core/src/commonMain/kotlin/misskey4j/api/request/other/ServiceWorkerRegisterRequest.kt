package misskey4j.api.request.other

import misskey4j.api.model.TokenRequest

class ServiceWorkerRegisterRequest(
    i: String
) : TokenRequest(i) {

    var endpoint: String? = null
    var auth: String? = null
    var publickey: String? = null
}
