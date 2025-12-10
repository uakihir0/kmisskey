package work.socialhub.kmisskey.api.request.pages

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class PagesDeleteRequest : TokenRequest() {
    var pageId: String? = null
}
