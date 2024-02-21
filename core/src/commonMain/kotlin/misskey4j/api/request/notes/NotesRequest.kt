package misskey4j.api.request.notes

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class NotesRequest(
    override var i: String
) : TokenRequest() {

    var local: Boolean? = null
    var reply: Boolean? = null
    var renote: Boolean? = null
    var withFiles: Boolean? = null
    var poll: Boolean? = null

    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
}


