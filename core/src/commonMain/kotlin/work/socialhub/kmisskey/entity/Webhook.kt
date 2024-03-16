package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
open class Webhook {

    var id: String? = null
    var createdAt: String? = null
    var userId: String? = null
    var name: String? = null
    var on: Array<String>? = null
    var url: String? = null
    var secret: String? = null
    var active: Boolean? = null
    var latestSentAt: String? = null
    var latestStatus: Int? = null
}
