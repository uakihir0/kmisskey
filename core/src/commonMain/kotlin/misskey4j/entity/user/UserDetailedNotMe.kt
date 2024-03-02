package misskey4j.entity.user

import kotlinx.serialization.Serializable
import misskey4j.entity.Field
import misskey4j.entity.Note
import misskey4j.entity.Page

@Serializable
open class UserDetailedNotMe : UserBasic() {

    var url: String? = null
    var uri: String? = null

    var moveTo: String? = null
    var alsoKnownAs: List<String>? = null

    lateinit var createdAt: String
    var updatedAt: String? = null
    var lastFetchedAt: String? = null

    var bannerUrl: String? = null
    var bannerBlurhash: String? = null

    var isLocked: Boolean = false
    var isSilenced: Boolean = false
    var isLimited: Boolean = false
    var isSuspended: Boolean = false

    var description: String? = null
    var location: String? = null
    var birthday: String? = null
    var lang: String? = null

    var fields: List<Field> = listOf()
    var verifiedLinks: List<String> = listOf()

    var followersCount: Long = 0
    var followingCount: Long = 0
    var notesCount: Long = 0

    var pinnedNoteIds: List<String> = listOf()
    var pinnedNotes: List<Note> = listOf()

    var pinnedPageId: String? = null
    var pinnedPage: Page? = null

    var publicReactions: Boolean = false

    lateinit var followingVisibility: String
    lateinit var followersVisibility: String

    var twoFactorEnabled: Boolean = false
    var usePasswordLessLogin: Boolean = false
    var securityKeys: Boolean = false

    // TODO: RoleLite
    // var roles: List<RoleLite> = listOf()

    var memo: String? = null

    var moderationNote: String? = null

    var isFollowing: Boolean = false
    var isFollowed: Boolean = false

    var hasPendingFollowRequestFromYou: Boolean = false
    var hasPendingFollowRequestToYou: Boolean = false

    var isBlocking: Boolean = false
    var isBlocked: Boolean = false
    var isMuted: Boolean = false
    var isRenoteMuted: Boolean = false

    var notify: String? = null
    var withReplies: Boolean = false
}