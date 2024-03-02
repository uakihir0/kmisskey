package misskey4j.api.request.notes

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class NotesConversationRequest : TokenRequest() {

    var noteId: String? = null
    var limit: Long? = null
    var offset: Long? = null
}
