package misskey4j.api.request

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class ChannelsTimelineRequest : TokenRequest() {

    var channelId: String? = null

    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
    var sinceDate: Long? = null
    var untilDate: Long? = null
}