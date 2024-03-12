package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class UsersNotesRequest : TokenRequest() {

    var userId: String? = null

    var limit: Int? = null
    var sinceId: String? = null
    var untilId: String? = null
    var sinceDate: Int? = null
    var untilDate: Int? = null

    var includeReplies: Boolean? = null
    var includeMyRenotes: Boolean? = null
    var excludeNsfw: Boolean? = null
    var withFiles: Boolean? = null
    var withChannelNotes: Boolean? = null
    var fileType: Array<String>? = null
}
