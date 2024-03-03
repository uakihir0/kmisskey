package work.socialhub.kmisskey.api.response

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.Note
import work.socialhub.kmisskey.entity.user.User

@Serializable
class ApShowResponse {
    var type: String? = null
    var note: Note? = null
    var user: User? = null
    var `object`: String? = null
}
