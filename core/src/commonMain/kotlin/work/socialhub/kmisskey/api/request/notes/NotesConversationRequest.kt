package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class NotesConversationRequest : TokenRequest() {

    var noteId: String? = null
    var limit: Int? = null
    var offset: Int? = null
}
