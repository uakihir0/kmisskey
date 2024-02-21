package misskey4j.api.request.users

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class UsersRecommendationRequest(
    override var i: String
) : TokenRequest() {

    var limit: Long? = null
    var offset: Long? = null
}
