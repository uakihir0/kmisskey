package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class NotesFeaturedRequest : TokenRequest() {

    var limit: Long? = null
    var offset: Long? = null
}
