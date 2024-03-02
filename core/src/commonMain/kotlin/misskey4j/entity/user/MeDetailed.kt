package misskey4j.entity.user

import kotlinx.serialization.Serializable
import misskey4j.entity.Achievement
import misskey4j.entity.SecurityKey

@Serializable
class MeDetailed : UserDetailedNotMe() {

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

    var hasUnreadAntenna: Boolean = false
    var hasUnreadChannel: Boolean = false
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
}