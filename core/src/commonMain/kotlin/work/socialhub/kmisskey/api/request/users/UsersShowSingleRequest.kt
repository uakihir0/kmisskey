package work.socialhub.kmisskey.api.request.users

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class UsersShowSingleRequest : TokenRequest() {

    var userId: String? = null
    var username: String? = null
    var host: String? = null
}
