package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable

@Serializable
open class DeletedNote {
    var id: String? = null
    var deletedAt: String? = null
}
