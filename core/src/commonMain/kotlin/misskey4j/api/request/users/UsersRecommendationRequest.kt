package misskey4j.api.request.users

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class UsersRecommendationRequest : TokenRequest() {

    var limit: Long? = null
    var offset: Long? = null
}
