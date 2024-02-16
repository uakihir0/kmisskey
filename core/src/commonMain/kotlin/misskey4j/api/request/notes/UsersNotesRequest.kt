package misskey4j.api.request.notes

import misskey4j.api.model.TokenRequest

class UsersNotesRequest(
    i: String
) : TokenRequest(i) {

    var userId: String? = null

    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
    var sinceDate: Long? = null
    var untilDate: Long? = null

    var includeReplies: Boolean? = null
    var includeMyRenotes: Boolean? = null
    var excludeNsfw: Boolean? = null
    var withFiles: Boolean? = null
    var fileType: List<String>? = null
}
