package misskey4j.api.request.lists

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class UsersListsPushRequest : TokenRequest() {

    var listId: String? = null
    var userId: String? = null
}
