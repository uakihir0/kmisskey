package misskey4j.entity

import kotlinx.serialization.Serializable
import misskey4j.entity.user.UserLite

@Serializable
open class Block {
    var id: String? = null
    var createdAt: String? = null
    var blockeeId: String? = null
    var blockee: UserLite? = null
}

