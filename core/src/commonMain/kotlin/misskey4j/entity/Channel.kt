package misskey4j.entity

import kotlinx.serialization.Serializable

@Serializable
class Channel {

    lateinit var id: String
    lateinit var name: String
    lateinit var createdAt: String

    var lastNotedAt: String? = null
    var description: String? = null
    var bannerUrl: String? = null

    var isArchived = false
    var notesCount = 0
    var usersCount = 0

    var isFollowing = false
    var isFavorited = false

    var userId: String? = null
    var pinnedNoteIds: List<String>? = null
    var color: String? = null
}
