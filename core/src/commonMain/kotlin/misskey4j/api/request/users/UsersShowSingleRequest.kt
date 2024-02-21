package misskey4j.api.request.users

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class UsersShowSingleRequest(
    override var i: String
) : TokenRequest() {

    var userId: String? = null
    var username: String? = null
    var host: String? = null
}
