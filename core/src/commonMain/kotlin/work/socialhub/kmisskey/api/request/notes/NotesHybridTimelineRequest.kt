package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.request.protocol.FullPagingTokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class NotesHybridTimelineRequest : FullPagingTokenRequest() {

    var includeMyRenotes: Boolean? = null
    var includeRenotedMyNotes: Boolean? = null
    var includeLocalRenotes: Boolean? = null
    var withFiles: Boolean? = null
}
