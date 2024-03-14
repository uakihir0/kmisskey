package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.user.User

@Serializable
class Clip {

    var id = ""
    var createdAt = ""
    var lastClippedAt: String? = null
    var userId = ""
    var user: User? = null
    var name = ""
    var description = ""
    var isPublic = false
    var favorited: Boolean? = null
    var favoritedCount = 0
}
