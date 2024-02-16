package misskey4j.api.request

import misskey4j.api.model.TokenRequest

class UsersListsPushRequest(
    i: String
) : TokenRequest(i) {

    var listId: String? = null
    var userId: String? = null
}
