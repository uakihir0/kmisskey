package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class NotesReactionsRequest : TokenRequest() {

    var noteId: String? = null
    var type: String? = null
    var limit: Int? = null
    var offset: Int? = null
    var sinceId: String? = null
    var untilId: String? = null
}
