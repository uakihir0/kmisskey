package misskey4j.api.request.gallery

import misskey4j.api.model.TokenRequest

class UpdateGalleryPostRequest(
    i: String,
    var postId: String,
    var title: String,
    var fileIds: List<String>,
) : TokenRequest(i) {
    var description: String? = null
    var isSensitive = false
}
