package work.socialhub.kmisskey.api.request.favorites

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class FavoritesDeleteRequest : TokenRequest() {

    var noteId: String? = null
}
