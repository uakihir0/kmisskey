package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
open class Group {

    var id: String? = null
    var createdAt: String? = null

    var name: String? = null
    var ownerId: String? = null
    var userIds: List<String>? = null
}


