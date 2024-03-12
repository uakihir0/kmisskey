package work.socialhub.kmisskey.api.request.reactions

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class ReactionsDeleteRequest : TokenRequest() {

    var noteId: String? = null
}
