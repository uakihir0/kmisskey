package misskey4j.api.request.users

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class UsersShowMultipleRequest(
    override var i: String
) : TokenRequest() {

    var userIds: List<String>? = null
}
