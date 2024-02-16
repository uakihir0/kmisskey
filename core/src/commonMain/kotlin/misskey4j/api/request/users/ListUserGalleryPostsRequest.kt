package misskey4j.api.request.users

import misskey4j.api.model.TokenRequest

class ListUserGalleryPostsRequest(
    i: String,
    var userId: String,
) : TokenRequest(i) {

    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
}
