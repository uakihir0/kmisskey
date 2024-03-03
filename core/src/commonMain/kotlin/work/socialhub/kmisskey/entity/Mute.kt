package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.user.User

@Serializable
open class Mute {

    var id: String? = null
    var createdAt: String? = null

    var muteeId: String? = null
    var mutee: User? = null
}
