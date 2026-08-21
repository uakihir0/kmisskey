package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.user.UserDetailedNotMe

@Serializable
open class RenoteMuting {

    var id: String? = null
    var createdAt: String? = null

    var muteeId: String? = null
    var mutee: UserDetailedNotMe? = null
}
