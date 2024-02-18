package misskey4j.entity

import kotlinx.serialization.Serializable

@Serializable
class NoteList {

    var id: String? = null
    var createdAt: String? = null
    var name: String? = null
    var userIds: List<String>? = null
}
