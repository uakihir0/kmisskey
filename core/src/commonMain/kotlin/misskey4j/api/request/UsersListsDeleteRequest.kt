package misskey4j.api.request

import misskey4j.api.model.TokenRequest

class UsersListsDeleteRequest(
    i: String,
    var listId: String,
) : TokenRequest(i)
