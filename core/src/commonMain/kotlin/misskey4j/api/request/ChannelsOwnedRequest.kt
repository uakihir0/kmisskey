package misskey4j.api.request

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class ChannelsOwnedRequest : TokenRequest() {

    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
}
