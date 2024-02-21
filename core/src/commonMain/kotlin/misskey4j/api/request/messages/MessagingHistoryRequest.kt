package misskey4j.api.request.messages

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class MessagingHistoryRequest(
    override var i: String
) : TokenRequest() {

    var limit: Long? = null
    var group: Boolean? = null
}
