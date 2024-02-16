package misskey4j.api.request.notes

import misskey4j.api.model.TokenRequest

class NotesRepliesRequest(
    i: String
) : TokenRequest(i) {

    var noteId: String? = null
    var sinceId: String? = null
    var untilId: String? = null
    var limit: Long? = null
}
