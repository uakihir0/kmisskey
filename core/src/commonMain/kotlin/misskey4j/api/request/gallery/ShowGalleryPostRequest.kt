package misskey4j.api.request.gallery

import misskey4j.api.model.TokenRequest

class ShowGalleryPostRequest(
    i:String,
) : TokenRequest(i) {

    var postId: String? = null
}