package misskey4j.api.request.notes

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class NotesChildrenRequest(
    override var i: String
) : TokenRequest() {

    var noteId: String? = null
    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
}