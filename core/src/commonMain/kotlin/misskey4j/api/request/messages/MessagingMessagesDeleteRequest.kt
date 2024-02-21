package misskey4j.api.request.messages

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class MessagingMessagesDeleteRequest(
    override var i: String
) : TokenRequest() {

    var messageId: String? = null
}
