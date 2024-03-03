package work.socialhub.kmisskey.api.request.users

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class UsersRecommendationRequest : TokenRequest() {

    var limit: Long? = null
    var offset: Long? = null
}
