package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class NotesGlobalTimelineRequest : TokenRequest() {

    var withFiles: Boolean? = null
    var limit: Long? = null

    var sinceId: String? = null
    var untilId: String? = null

    var sinceDate: Long? = null
    var untilDate: Long? = null
}
