package misskey4j.api.request.gallery

import misskey4j.api.model.TokenRequest

class ListGalleryPostsRequest(
    i: String
) : TokenRequest(i) {

    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
}
