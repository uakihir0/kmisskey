package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class NotesTimelineRequest : TokenRequest() {

    var limit: Int? = null
    var sinceId: String? = null
    var untilId: String? = null
    var sinceDate: Int? = null
    var untilDate: Int? = null

    var includeMyRenotes: Boolean? = null
    var includeRenotedMyNotes: Boolean? = null
    var includeLocalRenotes: Boolean? = null
    var withFiles: Boolean? = null
    var withReplies: Boolean? = null
}
