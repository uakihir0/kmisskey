package work.socialhub.kmisskey.entity.user

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.Achievement
import kotlin.js.JsExport

@JsExport
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
    var unreadNotificationsCount: Int = 0

    var mutedWords: Array<Array<String>> = arrayOf()
    var hardMutedWords: Array<Array<String>> = arrayOf()
    var mutedInstances: Array<String> = arrayOf()

    // TODO: Object
    // var notificationRecieveConfig: Array<Any> = listOf()

    var emailNotificationTypes: Array<String> = arrayOf()
    var achievements: Array<Achievement> = arrayOf()
    var loggedInDays: Int = 0

    // TODO: RolePolicies
    // var policies: List<RolePolicies> = listOf()

    var email: String? = null
    var emailVerified: Boolean = false
}