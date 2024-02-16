package misskey4j.api.request.mutes

import misskey4j.api.model.TokenRequest

class MutesCreateRequest(
    i:String
) : TokenRequest(i) {

    var userId: String? = null
}
