package work.socialhub.kmisskey.api.request.reactions

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class ReactionsCreateRequest : TokenRequest() {

    var noteId: String? = null
    var reaction: String? = null
}

