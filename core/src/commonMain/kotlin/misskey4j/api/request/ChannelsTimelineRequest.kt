package misskey4j.api.request

import misskey4j.api.model.TokenRequest

class ChannelsTimelineRequest(
    i: String
) : TokenRequest(i) {

    var channelId: String? = null

    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
    var sinceDate: Long? = null
    var untilDate: Long? = null
}