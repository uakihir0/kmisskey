package misskey4j.api.request.notes

import misskey4j.api.model.TokenRequest

class NotesGlobalTimelineRequest(
    i: String
) : TokenRequest(i) {

    var withFiles: Boolean? = null
    var limit: Long? = null

    var sinceId: String? = null
    var untilId: String? = null

    var sinceDate: Long? = null
    var untilDate: Long? = null
}
