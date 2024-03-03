package work.socialhub.kmisskey.api.response.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.Note
import work.socialhub.kmisskey.entity.user.User

@Serializable
class UsersReactionsResponse {

    var id: String? = null
    var createdAt: String? = null
    var user: User? = null
    var type: String? = null
    var note: Note? = null
}
