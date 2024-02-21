package misskey4j.api.request.lists

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class UsersListsShowRequest(
   override var i: String
) : TokenRequest() {

    var listId: String? = null
}
