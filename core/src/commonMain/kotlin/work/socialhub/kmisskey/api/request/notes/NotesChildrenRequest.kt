package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class NotesChildrenRequest : TokenRequest() {

    var noteId: String? = null
    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
}