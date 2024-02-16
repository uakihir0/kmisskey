package misskey4j.api.request.notes

import misskey4j.api.model.TokenRequest

class NotesFeaturedRequest(
    i: String
) : TokenRequest(i) {

    var limit: Long? = null
    var offset: Long? = null
}
