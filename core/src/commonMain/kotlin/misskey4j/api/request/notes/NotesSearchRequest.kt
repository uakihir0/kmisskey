package misskey4j.api.request.notes

import misskey4j.api.model.TokenRequest

class NotesSearchRequest(
    i: String
) : TokenRequest(i) {

    var query: String? = null
    var sinceId: String? = null
    var untilId: String? = null
    var limit: Long? = null
    var host: String? = null
    var userId: String? = null
}
