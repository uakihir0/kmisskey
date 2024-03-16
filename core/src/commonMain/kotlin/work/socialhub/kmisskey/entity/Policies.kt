package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Policies {

    var gtlAvailable: Boolean? = null
    var ltlAvailable: Boolean? = null
    var canPublicNote: Boolean? = null
    var canInvite: Boolean? = null
}
