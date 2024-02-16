package misskey4j.api.request.reactions

import misskey4j.api.model.TokenRequest

class ReactionsCreateRequest(
    i: String
) : TokenRequest(i) {

    var noteId: String? = null
    var reaction: String? = null
}

