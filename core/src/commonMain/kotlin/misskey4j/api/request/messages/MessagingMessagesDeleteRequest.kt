package misskey4j.api.request.messages

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class MessagingMessagesDeleteRequest : TokenRequest() {

    var messageId: String? = null
}
