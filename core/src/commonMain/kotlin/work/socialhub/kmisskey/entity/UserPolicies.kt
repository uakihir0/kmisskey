package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable

@Serializable
class UserPolicies {

    var gtlAvailable: Boolean? = null
    var ltlAvailable: Boolean? = null
    var canPublicNote: Boolean? = null
    var canInvite: Boolean? = null
    var canManageCustomEmojis: Boolean? = null
    var canSearchNotes: Boolean? = null
    var canHideAds: Boolean? = null
    var driveCapacityMb: Long? = null
    var alwaysMarkNsfw: Boolean? = null
    var pinLimit: Long? = null
    var antennaLimit: Long? = null
    var wordMuteLimit: Long? = null
    var webhookLimit: Long? = null
    var clipLimit: Long? = null
    var noteEachClipsLimit: Long? = null
    var userListLimit: Long? = null
    var userEachUserListsLimit: Long? = null

    var rateLimitFactor: Double? = null
}
