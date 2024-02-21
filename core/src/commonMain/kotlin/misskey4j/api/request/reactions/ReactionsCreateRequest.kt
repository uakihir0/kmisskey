package misskey4j.api.request.reactions

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class ReactionsCreateRequest(
    override var i: String
) : TokenRequest() {

    var noteId: String? = null
    var reaction: String? = null
}

