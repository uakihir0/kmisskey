package work.socialhub.kmisskey.api.response.following

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.user.User

@Serializable
class FollowingRequestsListResponse {

    var id: String? = null
    var follower: User? = null
    var followee: User? = null
}
