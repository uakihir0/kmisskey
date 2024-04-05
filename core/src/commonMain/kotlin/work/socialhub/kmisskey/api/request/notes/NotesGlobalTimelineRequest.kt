package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.request.protocol.FullPagingTokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class NotesGlobalTimelineRequest : FullPagingTokenRequest() {

    var withFiles: Boolean? = null
}
