package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Antenna {

    lateinit var id: String
    lateinit var createdAt: String
    lateinit var name: String

    var keywords: Array<Array<String>> = arrayOf()
    var excludeKeywords: Array<Array<String>> = arrayOf()
    var src: String = "all"

    var userListId: String? = null
    var users: Array<String> = arrayOf()

    var caseSensitive: Boolean = false
    var localOnly: Boolean = false
    var notify: Boolean = false
    var withReplies: Boolean = false
    var withFile: Boolean = false
    var isActive: Boolean = false
    var hasUnreadNote: Boolean = false
}
