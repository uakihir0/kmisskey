package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import work.socialhub.kmisskey.api.request.protocol.PagingBuilder
import kotlin.js.JsExport

@JsExport
@Serializable
class NotesRepliesRequest : PagingBuilder, TokenRequest() {

    var noteId: String? = null

    override var limit: Int? = null
    override var sinceId: String? = null
    override var untilId: String? = null
}
