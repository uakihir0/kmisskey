package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class NoteUnrenoteRequest : TokenRequest() {

    var noteId: String? = null
}
