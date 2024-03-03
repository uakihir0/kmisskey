package work.socialhub.kmisskey.api.request.messages

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class MessagingHistoryRequest : TokenRequest() {

    var limit: Long? = null
    var group: Boolean? = null
}
