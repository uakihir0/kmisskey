package misskey4j.api.request.following

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class FollowingCreateRequest : TokenRequest() {

    var userId: String? = null
}
