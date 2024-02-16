package misskey4j.api.request.blocks

import misskey4j.api.model.TokenRequest

class BlocksListRequest(
    i: String
) : TokenRequest(i) {

    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
}
