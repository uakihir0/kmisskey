package misskey4j.api.request.notes

import misskey4j.api.model.TokenRequest

class NotesChildrenRequest(
    i: String
) : TokenRequest(i) {

    var noteId: String? = null
    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
}