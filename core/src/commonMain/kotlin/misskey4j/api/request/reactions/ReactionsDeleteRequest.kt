package misskey4j.api.request.reactions

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class ReactionsDeleteRequest(
    override var i: String
) : TokenRequest() {

    var noteId: String? = null
}
