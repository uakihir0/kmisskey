package misskey4j.api.request

import misskey4j.api.model.TokenRequest

class ChannelsFollowedRequest(
    i: String
) : TokenRequest(i) {

    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
}
