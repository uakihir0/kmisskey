package work.socialhub.kmisskey.api.request.users

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class ListUserGalleryPostsRequest(
    var userId: String,
) : TokenRequest() {

    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
}
