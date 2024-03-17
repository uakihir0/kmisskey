package work.socialhub.kmisskey.api.request.i

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import work.socialhub.kmisskey.entity.Field
import kotlin.js.JsExport

@JsExport
@Serializable
class IUpdateRequest : TokenRequest() {

    var name: String? = null
    var description: String? = null
    var location: String? = null
    var birthday: String? = null
    var lang: String? = null
    var avatarId: String? = null
    var bannerId: String? = null
    var fields: Array<Field> = arrayOf()
    var isLocked: Boolean? = null
    var isExplorable: Boolean? = null
    var hideOnlineStatus: Boolean? = null
    var publicReactions: Boolean? = null
    var carefulBot: Boolean? = null
    var autoAcceptFollowed: Boolean? = null
    var noCrawle: Boolean? = null
    var preventAiLearning: Boolean? = null
    var isBot: Boolean? = null
    var isCat: Boolean? = null
    var injectFeaturedNote: Boolean? = null
    var receiveAnnouncementEmail: Boolean? = null
    var alwaysMarkNsfw: Boolean? = null
    var autoSensitive: Boolean? = null
    var ffVisibility: String? = null
    var pinnedPageId: String? = null
    var mutedWords: Array<Array<String>> = arrayOf()
    var mutedInstances: Array<String> = arrayOf()
    var mutingNotificationTypes: Array<String> = arrayOf()
    var emailNotificationTypes: Array<String> = arrayOf()
    var alsoKnownAs: Array<String> = arrayOf()
}