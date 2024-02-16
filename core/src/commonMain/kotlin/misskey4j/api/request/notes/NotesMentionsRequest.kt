package misskey4j.api.request.notes

import misskey4j.api.model.TokenRequest

class NotesMentionsRequest(
    i: String
) : TokenRequest(i) {

    var following: Boolean? = null
    var limit: Long? = null

    var sinceId: String? = null
    var untilId: String? = null
    var visibility: String? = null
}
