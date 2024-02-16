package misskey4j.api.request.blocks

import misskey4j.api.model.TokenRequest

class BlocksDeleteRequest(
    i: String
) : TokenRequest(i) {

    var userId: String? = null
}
