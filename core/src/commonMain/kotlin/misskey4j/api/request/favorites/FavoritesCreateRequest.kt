package misskey4j.api.request.favorites

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class FavoritesCreateRequest(
    override var i: String
) : TokenRequest() {

    var noteId: String? = null
}
