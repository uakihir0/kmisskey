package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable

@Serializable
open class Announcements {

    var id: String? = null
    var createdAt: String? = null

    var updatedAt: String? = null
    var text: String? = null
    var title: String? = null

    var imageUrl: String? = null

    var read: Boolean? = null
}
