package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable

@Serializable
open class Channel {

    lateinit var id: String

    /**
     * ドキュメント内では required になっているが null の場合もある
     * Required in the documentation, but may be null
     */
    var createdAt: String? = null

    var lastNotedAt: String? = null
    lateinit var name: String
    var description: String? = null

    var userId: String? = null
    var bannerUrl: String? = null
    var pinnedNoteIds: List<String> = listOf()

    lateinit var color: String

    var isArchived: Boolean = false
    var notesCount: Long = 0
    var usersCount: Long = 0

    var isSensitive: Boolean = false
    var allowRenoteToExternal: Boolean = false
    var isFollowing: Boolean = false
    var isFavorited: Boolean = false

    var pinnedNotes: List<Note> = listOf()
}
