package work.socialhub.kmisskey.api.request.messages

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class MessagingMessagesRequest : TokenRequest() {

    var userId: String? = null
    var groupId: String? = null
    var limit: Int? = null

    var sinceId: String? = null
    var untilId: String? = null
    var markAsRead: Boolean? = null
}
