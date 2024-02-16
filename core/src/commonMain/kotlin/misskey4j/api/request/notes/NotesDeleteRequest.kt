package misskey4j.api.request.notes

import misskey4j.api.model.TokenRequest

class NotesDeleteRequest(
    i: String
) : TokenRequest(i) {

    var noteId: String? = null
}
