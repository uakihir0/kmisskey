package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.user.User
import kotlin.js.JsExport

@JsExport
@Serializable
open class Notification {
    lateinit var id: String
    lateinit var createdAt: String
    lateinit var type: String

    var user: User? = null
    var userId: String? = null
    var note: Note? = null

    var reaction: String? = null
    var choice: Int? = null

    // TODO parse invitation object
    var body: String? = null

    var header: String? = null
    var icon: String? = null
    var achievement: String? = null
}
