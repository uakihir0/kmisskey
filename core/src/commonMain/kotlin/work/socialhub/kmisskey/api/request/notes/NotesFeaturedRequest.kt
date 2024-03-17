package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class NotesFeaturedRequest : TokenRequest() {

    var limit: Int? = null
    var offset: Int? = null
}
