package work.socialhub.kmisskey.api.request.following

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class FollowingRequestsListRequest : TokenRequest() {

    var sinceId: String? = null
    var untilId: String? = null
    var limit: Long? = null
}
