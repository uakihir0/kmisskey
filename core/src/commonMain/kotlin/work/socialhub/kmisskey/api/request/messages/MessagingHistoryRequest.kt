package work.socialhub.kmisskey.api.request.messages

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class MessagingHistoryRequest : TokenRequest() {

    var limit: Int? = null
    var group: Boolean? = null
}
