package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
open class NoteList {

    var id: String? = null
    var createdAt: String? = null
    var name: String? = null
    var userIds: Array<String>? = null
}
