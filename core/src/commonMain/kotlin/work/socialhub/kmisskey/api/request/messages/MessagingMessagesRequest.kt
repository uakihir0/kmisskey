package work.socialhub.kmisskey.api.request.messages

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class MessagingMessagesRequest : TokenRequest() {

    var userId: String? = null
    var groupId: String? = null
    var limit: Long? = null

    var sinceId: String? = null
    var untilId: String? = null
    var markAsRead: Boolean? = null
}
