package misskey4j.entity

import kotlinx.serialization.Serializable
import misskey4j.entity.user.User
import misskey4j.entity.user.UserLite

@Serializable
open class Mute {

    var id: String? = null
    var createdAt: String? = null

    var muteeId: String? = null
    var mutee: User? = null
}
