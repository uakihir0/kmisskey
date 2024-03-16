package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.user.UserLite
import kotlin.js.JsExport

@JsExport
@Serializable
class Clip {

    lateinit var id: String
    lateinit var createdAt: String
    var lastClippedAt: String? = null

    lateinit var userId: String
    lateinit var user: UserLite

    lateinit var name: String
    var description: String? = null

    var isPublic: Boolean = false
    var favoritedCount: Int = 0
    var isFavorited: Boolean = false
}
