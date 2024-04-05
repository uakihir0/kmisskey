package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.request.protocol.FullPagingTokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class UsersNotesRequest : FullPagingTokenRequest() {

    var userId: String? = null

    var includeReplies: Boolean? = null
    var includeMyRenotes: Boolean? = null
    var excludeNsfw: Boolean? = null
    var withFiles: Boolean? = null
    var withChannelNotes: Boolean? = null
    var fileType: Array<String>? = null
}
