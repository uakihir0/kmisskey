package misskey4j.api.request.messages

import misskey4j.api.model.TokenRequest

class MessagingMessagesDeleteRequest(
    i:String
) : TokenRequest(i) {

    var messageId: String? = null
}
