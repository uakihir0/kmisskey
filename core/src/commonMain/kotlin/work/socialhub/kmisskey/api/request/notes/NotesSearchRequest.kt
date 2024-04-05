package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.request.protocol.PagingTokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class NotesSearchRequest : PagingTokenRequest() {

    var query: String? = null
    var host: String? = null
    var userId: String? = null
}
