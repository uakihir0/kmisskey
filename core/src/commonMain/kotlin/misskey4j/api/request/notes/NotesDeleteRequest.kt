package misskey4j.api.request.notes

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class NotesDeleteRequest : TokenRequest() {

    var noteId: String? = null
}
