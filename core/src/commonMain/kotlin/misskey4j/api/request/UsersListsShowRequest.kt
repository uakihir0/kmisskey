package misskey4j.api.request

import misskey4j.api.model.TokenRequest

class UsersListsShowRequest(
    i: String
) : TokenRequest(i) {

    var listId: String? = null
}
