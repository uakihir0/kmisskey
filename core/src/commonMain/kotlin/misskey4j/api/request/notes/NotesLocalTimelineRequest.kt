package misskey4j.api.request.notes

import misskey4j.api.model.TokenRequest

class NotesLocalTimelineRequest(
    i: String
) : TokenRequest(i) {

    var withFiles: Boolean? = null
    var fileType: List<String>? = null

    var excludeNsfw: Boolean? = null
    var limit: Long? = null

    var sinceId: String? = null
    var untilId: String? = null
    var sinceDate: Long? = null
    var untilDate: Long? = null
}
