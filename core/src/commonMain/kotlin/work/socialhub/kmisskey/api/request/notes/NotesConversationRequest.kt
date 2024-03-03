package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class NotesConversationRequest : TokenRequest() {

    var noteId: String? = null
    var limit: Long? = null
    var offset: Long? = null
}
