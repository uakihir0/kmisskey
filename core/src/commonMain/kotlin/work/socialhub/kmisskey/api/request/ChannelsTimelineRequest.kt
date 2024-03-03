package work.socialhub.kmisskey.api.request

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class ChannelsTimelineRequest : TokenRequest() {

    var channelId: String? = null

    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
    var sinceDate: Long? = null
    var untilDate: Long? = null
}