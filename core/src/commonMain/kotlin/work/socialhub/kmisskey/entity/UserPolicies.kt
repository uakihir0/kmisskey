package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class UserPolicies {

    var gtlAvailable: Boolean? = null
    var ltlAvailable: Boolean? = null
    var canPublicNote: Boolean? = null
    var canInvite: Boolean? = null
    var canManageCustomEmojis: Boolean? = null
    var canSearchNotes: Boolean? = null
    var canHideAds: Boolean? = null
    var driveCapacityMb: Int? = null
    var alwaysMarkNsfw: Boolean? = null
    var pinLimit: Int? = null
    var antennaLimit: Int? = null
    var wordMuteLimit: Int? = null
    var webhookLimit: Int? = null
    var clipLimit: Int? = null
    var noteEachClipsLimit: Int? = null
    var userListLimit: Int? = null
    var userEachUserListsLimit: Int? = null

    var rateLimitFactor: Double? = null
}
