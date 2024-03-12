package work.socialhub.kmisskey.api.response.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.user.User
import kotlin.js.JsExport

@JsExport
@Serializable
class NotesReactionsResponse {

    var id: String? = null
    var createdAt: String? = null
    var user: User? = null
    var type: String? = null
}
