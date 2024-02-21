package misskey4j.api.request.users

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class ListUserGalleryPostsRequest(
    override var i: String,
    var userId: String,
) : TokenRequest() {

    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
}
