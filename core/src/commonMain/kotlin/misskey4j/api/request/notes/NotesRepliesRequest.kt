package misskey4j.api.request.notes

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class NotesRepliesRequest : TokenRequest() {

    var noteId: String? = null
    var sinceId: String? = null
    var untilId: String? = null
    var limit: Long? = null
}
