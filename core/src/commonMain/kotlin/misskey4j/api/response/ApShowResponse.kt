package misskey4j.api.response

import kotlinx.serialization.Serializable
import misskey4j.entity.Note
import misskey4j.entity.user.User
import misskey4j.entity.user.UserLite

@Serializable
class ApShowResponse {
    var type: String? = null
    var note: Note? = null
    var user: User? = null
    var `object`: String? = null
}
