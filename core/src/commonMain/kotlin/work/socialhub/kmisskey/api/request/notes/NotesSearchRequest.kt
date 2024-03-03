package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class NotesSearchRequest : TokenRequest() {

    var query: String? = null
    var sinceId: String? = null
    var untilId: String? = null
    var limit: Long? = null
    var host: String? = null
    var userId: String? = null
}
