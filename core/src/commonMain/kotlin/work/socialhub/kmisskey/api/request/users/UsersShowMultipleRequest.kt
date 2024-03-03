package work.socialhub.kmisskey.api.request.users

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class UsersShowMultipleRequest : TokenRequest() {

    var userIds: List<String>? = null
}
