package misskey4j.entity

import kotlinx.serialization.Serializable

@Serializable
open class Follow {

    var id: String? = null
    var createdAt: String? = null

    var followeeId: String? = null
    var followee: User? = null

    var followerId: String? = null
    var follower: User? = null
}
