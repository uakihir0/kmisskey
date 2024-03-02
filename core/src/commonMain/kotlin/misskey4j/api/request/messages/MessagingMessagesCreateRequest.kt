package misskey4j.api.request.messages

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class MessagingMessagesCreateRequest : TokenRequest() {

    var userId: String? = null
    var groupId: String? = null
    var text: String? = null
    var fileId: String? = null
}
