package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.user.UserLite

@Serializable
open class Block {
    var id: String? = null
    var createdAt: String? = null
    var blockeeId: String? = null
    var blockee: UserLite? = null
}

