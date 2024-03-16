package work.socialhub.kmisskey.api.request.messages

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class MessagingMessagesCreateRequest : TokenRequest() {

    var userId: String? = null
    var groupId: String? = null
    var text: String? = null
    var fileId: String? = null
}
