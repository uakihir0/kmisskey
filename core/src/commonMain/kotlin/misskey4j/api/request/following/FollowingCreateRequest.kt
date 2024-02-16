package misskey4j.api.request.following

import misskey4j.api.model.TokenRequest

class FollowingCreateRequest(
    i: String
) : TokenRequest(i) {

    var userId: String? = null
}
