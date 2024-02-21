package misskey4j.api.request.notes

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class NotesGlobalTimelineRequest(
    override var i: String
) : TokenRequest() {

    var withFiles: Boolean? = null
    var limit: Long? = null

    var sinceId: String? = null
    var untilId: String? = null

    var sinceDate: Long? = null
    var untilDate: Long? = null
}
