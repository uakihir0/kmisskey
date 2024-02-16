package misskey4j.api.request.users

import misskey4j.api.model.TokenRequest

class UsersRelationRequest(
    i: String
) : TokenRequest(i) {

    var userId: List<String>? = null
}
