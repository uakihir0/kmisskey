package misskey4j.api.request.favorites

import misskey4j.api.model.TokenRequest

class FavoritesCreateRequest(
    i: String
) : TokenRequest(i) {

    var noteId: String? = null
}
