package misskey4j.api.request.gallery

import misskey4j.api.model.TokenRequest

class UnlikeGalleryPostRequest(
    i: String,
    var postId: String,
) : TokenRequest(i) {
}
