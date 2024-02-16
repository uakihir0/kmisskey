package misskey4j.api.request.users

import misskey4j.api.model.TokenRequest

class UsersShowSingleRequest(
    i: String
) : TokenRequest(i) {

    var userId: String? = null
    var username: String? = null
    var host: String? = null
}
