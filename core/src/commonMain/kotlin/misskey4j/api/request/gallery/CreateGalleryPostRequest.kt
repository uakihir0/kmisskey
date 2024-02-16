package misskey4j.api.request.gallery

import misskey4j.api.model.TokenRequest

class CreateGalleryPostRequest(
    i: String,
    var title: String,
    var fileIds: List<String>,
) : TokenRequest(i) {

    var description: String? = null
    var isSensitive: Boolean = false
}
