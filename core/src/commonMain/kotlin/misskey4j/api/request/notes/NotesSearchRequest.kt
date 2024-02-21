package misskey4j.api.request.notes

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class NotesSearchRequest(
    override var i: String
) : TokenRequest() {

    var query: String? = null
    var sinceId: String? = null
    var untilId: String? = null
    var limit: Long? = null
    var host: String? = null
    var userId: String? = null
}
