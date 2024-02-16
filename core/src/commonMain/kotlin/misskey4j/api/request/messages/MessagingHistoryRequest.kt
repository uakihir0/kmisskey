package misskey4j.api.request.messages

import misskey4j.api.model.TokenRequest

class MessagingHistoryRequest(
    i:String
) : TokenRequest(i) {

    var limit: Long? = null
    var group: Boolean? = null
}
