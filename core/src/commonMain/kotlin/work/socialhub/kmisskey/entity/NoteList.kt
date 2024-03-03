package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable

@Serializable
open class NoteList {

    var id: String? = null
    var createdAt: String? = null
    var name: String? = null
    var userIds: List<String>? = null
}
