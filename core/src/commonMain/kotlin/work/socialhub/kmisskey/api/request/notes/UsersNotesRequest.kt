package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import work.socialhub.kmisskey.api.request.protocol.FullPagingBuilder
import kotlin.js.JsExport

@JsExport
@Serializable
class UsersNotesRequest : FullPagingBuilder, TokenRequest() {

    var userId: String? = null

    var includeReplies: Boolean? = null
    var includeMyRenotes: Boolean? = null
    var excludeNsfw: Boolean? = null
    var withFiles: Boolean? = null
    var withChannelNotes: Boolean? = null
    var fileType: Array<String>? = null

    override var limit: Int? = null
    override var sinceId: String? = null
    override var untilId: String? = null
    override var sinceDate: Int? = null
    override var untilDate: Int? = null
}
