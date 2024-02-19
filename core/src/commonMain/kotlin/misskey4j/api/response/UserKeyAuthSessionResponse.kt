package misskey4j.api.response

import kotlinx.serialization.Serializable
import misskey4j.entity.User

@Serializable
class UserKeyAuthSessionResponse {
    var accessToken: String? = null
    var user: User? = null
}
