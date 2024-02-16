package misskey4j.api.request.users

import misskey4j.api.model.TokenRequest

class UsersRecommendationRequest(
    i: String
) : TokenRequest(i) {

    var limit: Long? = null
    var offset: Long? = null
}
