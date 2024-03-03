package work.socialhub.kmisskey.api.request.users

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class UsersRelationRequest : TokenRequest() {

    var userId: List<String>? = null
}
