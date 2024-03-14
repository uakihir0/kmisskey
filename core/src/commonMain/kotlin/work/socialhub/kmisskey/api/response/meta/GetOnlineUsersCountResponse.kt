package work.socialhub.kmisskey.api.response.meta

import kotlinx.serialization.Serializable

@Serializable
class GetOnlineUsersCountResponse {
    var count: Long? = null
}
