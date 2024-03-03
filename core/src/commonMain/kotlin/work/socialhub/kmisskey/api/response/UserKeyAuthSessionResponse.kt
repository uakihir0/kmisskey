package work.socialhub.kmisskey.api.response

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.user.User

@Serializable
class UserKeyAuthSessionResponse {
    var accessToken: String? = null
    var user: User? = null
}
