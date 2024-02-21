package misskey4j.api.request.notes

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class NoteUnrenoteRequest(
    override var i: String
) : TokenRequest() {

    var noteId: String? = null
}
