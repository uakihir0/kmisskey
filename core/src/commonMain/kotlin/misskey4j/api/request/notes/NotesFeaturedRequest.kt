package misskey4j.api.request.notes

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class NotesFeaturedRequest : TokenRequest() {

    var limit: Long? = null
    var offset: Long? = null
}
