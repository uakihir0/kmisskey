package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
open class Announcements {

    lateinit var id: String
    lateinit var createdAt: String
    var updatedAt: String? = null

    lateinit var text: String
    lateinit var title: String
    var imageUrl: String? = null

    lateinit var icon: String
    lateinit var display: String

    var needConfirmationToRead: Boolean = false
    var forYou: Boolean = false

    var closeDuration: Int = 0
    var displayOrder: Int = 0

    var silenced: Boolean = false
    var isRead: Boolean = false
}
