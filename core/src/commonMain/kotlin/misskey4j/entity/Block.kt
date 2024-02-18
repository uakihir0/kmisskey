package misskey4j.entity

import kotlinx.serialization.Serializable

@Serializable
open class Block {
    var id: String? = null
    var createdAt: String? = null
    var blockeeId: String? = null
    var blockee: User? = null
}

