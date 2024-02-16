package misskey4j.api.request

import misskey4j.api.model.TokenRequest

class ChannelsShowRequest(
    i: String
) : TokenRequest(i) {

    var channelId: String? = null
}