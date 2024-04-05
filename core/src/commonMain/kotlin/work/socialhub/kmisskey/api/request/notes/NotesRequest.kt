package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.request.protocol.PagingTokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class NotesRequest : PagingTokenRequest() {

    var local: Boolean? = null
    var reply: Boolean? = null
    var renote: Boolean? = null
    var withFiles: Boolean? = null
    var poll: Boolean? = null
}


