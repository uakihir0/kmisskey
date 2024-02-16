package misskey4j.api.request.messages

import misskey4j.api.model.TokenRequest

class MessagingMessagesCreateRequest(
    i:String
) : TokenRequest(i) {

    var userId: String? = null
    var groupId: String? = null
    var text: String? = null
    var fileId: String? = null
}
