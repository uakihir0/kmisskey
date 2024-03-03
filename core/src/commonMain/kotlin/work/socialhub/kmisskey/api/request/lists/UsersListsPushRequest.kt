package work.socialhub.kmisskey.api.request.lists

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class UsersListsPushRequest : TokenRequest() {

    var listId: String? = null
    var userId: String? = null
}
