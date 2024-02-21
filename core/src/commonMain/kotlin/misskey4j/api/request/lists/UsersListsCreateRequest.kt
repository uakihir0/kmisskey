package misskey4j.api.request.lists

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class UsersListsCreateRequest(
    override var i: String,
    var name: String,
) : TokenRequest()