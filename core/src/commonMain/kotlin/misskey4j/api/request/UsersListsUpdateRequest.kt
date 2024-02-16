package misskey4j.api.request

import misskey4j.api.model.TokenRequest

class UsersListsUpdateRequest(
    i: String,
    var listId: String,
    var name: String,
) : TokenRequest(i)
