package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class NotesGlobalTimelineRequest : TokenRequest() {

    var withFiles: Boolean? = null
    var limit: Int? = null

    var sinceId: String? = null
    var untilId: String? = null

    var sinceDate: Int? = null
    var untilDate: Int? = null
}
