package work.socialhub.kmisskey.api.request.favorites

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class FavoritesCreateRequest : TokenRequest() {

    var noteId: String? = null
}
