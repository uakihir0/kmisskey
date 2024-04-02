package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import work.socialhub.kmisskey.api.request.protocol.FullPagingBuilder
import work.socialhub.kmisskey.api.request.protocol.PagingBuilder
import kotlin.js.JsExport

@JsExport
@Serializable
class NotesTimelineRequest : FullPagingBuilder, TokenRequest() {

    var includeMyRenotes: Boolean? = null
    var includeRenotedMyNotes: Boolean? = null
    var includeLocalRenotes: Boolean? = null
    var withFiles: Boolean? = null
    var withReplies: Boolean? = null

    override var limit: Int? = null
    override var sinceId: String? = null
    override var untilId: String? = null
    override var sinceDate: Int? = null
    override var untilDate: Int? = null
}
