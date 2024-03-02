package misskey4j.entity

import kotlinx.serialization.Serializable
import misskey4j.util.BlurHashDecoder

/**
 * UserObject
 * - UserLite
 * - UserDetailedNotMe
 * - MeDetailed
 */
@Serializable
open class User {

    /// ------------------------------------------------- ///
    /// UserLite
    /// ------------------------------------------------- ///

    lateinit var id: String
    var name: String? = null
    lateinit var username: String

    /** The local host is represented with null. */
    var host: String? = null

    var avatarUrl: String? = null
    var avatarBlurhash: String? = null
    var avatarDecorations: List<AvatarDecoration> = listOf()

    var isBot: Boolean = false
    var isCat: Boolean = false

    var instance: Instance? = null
    var emojis: Emojis? = null
    lateinit var onlineStatus: String
    var badgeRoles: List<BadgeRole> = listOf()

    /// ------------------------------------------------- ///
    /// UserDetailedNotMe
    /// ------------------------------------------------- ///

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

    /// ------------------------------------------------- ///
    /// MeDetailed (Additional)
    /// ------------------------------------------------- ///

    var avatarId: String? = null
    var bannerId: String? = null

    var isModerator: Boolean = false
    var isAdmin: Boolean = false

    var injectFeaturedNote: Boolean = false
    var receiveAnnouncementEmail: Boolean = false
    var alwaysMarkNsfw: Boolean = false
    var autoSensitive: Boolean = false
    var carefulBot: Boolean = false

    var autoAcceptFollowed: Boolean = false
    var noCrawle: Boolean = false
    var preventAiLearning: Boolean = false
    var isExplorable: Boolean = false
    var isDeleted: Boolean = false

    var twoFactorBackupCodesStock: String? = null

    var hideOnlineStatus: Boolean = false
    var hasUnreadSpecifiedNotes: Boolean = false
    var hasUnreadMentions: Boolean = false
    var hasUnreadAnnouncement: Boolean = false

    // TODO: Announcement
    // var unreadAnnouncements: List<Announcement> = listOf()

    var hasUnreadAntenna:  Boolean = false
    var hasUnreadChannel:  Boolean = false
    var hasUnreadNotifications: Boolean = false
    var hasPendingReceivedFollowRequest: Boolean = false
    var unreadNotificationsCount: Long = 0

    var mutedWords: List<String> = listOf()
    var mutedInstances: List<String> = listOf()

    // TODO: Object
    // var notificationRecieveConfig: List<Any> = listOf()

    var emailNotificationTypes: List<String> = listOf()
    var achievements: List<Achievement> = listOf()
    var loggedInDays: Long = 0

    // TODO: RolePolicies
    // var policies: List<RolePolicies> = listOf()

    var email: String? = null
    var emailVerified: Boolean = false
    var securityKeysList: List<SecurityKey> = listOf()

    /**
     * The following are original items.
     * 以下、独自項目
     */

    var avatarColor: Color? = null
        get() {
            if (field == null) {
                val decoder = BlurHashDecoder.instance
                val ary = decoder.decode(
                    avatarBlurhash,
                    1,
                    1,
                    1F,
                    false
                ) ?: return null

                val color = Color()
                color.r = ary[0][0][0]
                color.g = ary[0][0][1]
                color.b = ary[0][0][2]
                return color
            }
            return field
        }
}
