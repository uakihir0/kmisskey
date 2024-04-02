package work.socialhub.kmisskey.api.request.messages

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import work.socialhub.kmisskey.api.request.protocol.PagingBuilder
import kotlin.js.JsExport

@JsExport
@Serializable
class MessagingMessagesRequest : PagingBuilder, TokenRequest() {

    var userId: String? = null
    var groupId: String? = null
    var markAsRead: Boolean? = null

    override var limit: Int? = null
    override var sinceId: String? = null
    override var untilId: String? = null
}
