package misskey4j.api.request

import misskey4j.api.model.TokenRequest

class UsersListsCreateRequest(
    i: String,
    var name: String,
) : TokenRequest(i)
