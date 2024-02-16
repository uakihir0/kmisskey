package misskey4j.api.request

import misskey4j.api.model.TokenRequest

class ApShowRequest(
    i: String
) : TokenRequest(i) {

    var uri: String? = null
}
