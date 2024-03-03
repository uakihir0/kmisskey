package work.socialhub.kmisskey.api.request.reactions

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class ReactionsDeleteRequest : TokenRequest() {

    var noteId: String? = null
}
