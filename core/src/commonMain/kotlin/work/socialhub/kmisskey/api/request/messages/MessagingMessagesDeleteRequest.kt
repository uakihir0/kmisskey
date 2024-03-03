package work.socialhub.kmisskey.api.request.messages

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class MessagingMessagesDeleteRequest : TokenRequest() {

    var messageId: String? = null
}
