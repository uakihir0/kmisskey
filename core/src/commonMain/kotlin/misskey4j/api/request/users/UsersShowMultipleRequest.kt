package misskey4j.api.request.users

import misskey4j.api.model.TokenRequest

class UsersShowMultipleRequest(
    i: String
) : TokenRequest(i) {

    var userIds: List<String>? = null
}
