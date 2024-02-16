package misskey4j.api.request.notes

import misskey4j.api.model.TokenRequest

class NotesRequest(
    i: String
) : TokenRequest(i) {

    var local: Boolean? = null
    var reply: Boolean? = null
    var renote: Boolean? = null
    var withFiles: Boolean? = null
    var poll: Boolean? = null

    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
}


