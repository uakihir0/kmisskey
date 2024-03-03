package work.socialhub.kmisskey.api.request

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class ChannelsShowRequest : TokenRequest() {

    var channelId: String? = null
}