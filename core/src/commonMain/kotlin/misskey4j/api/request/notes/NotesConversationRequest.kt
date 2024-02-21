package misskey4j.api.request.notes

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class NotesConversationRequest(
    override var i: String
) : TokenRequest() {

    var noteId: String? = null
    var limit: Long? = null
    var offset: Long? = null
}
