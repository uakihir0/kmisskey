package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.user.User

@Serializable
open class Message {

    var id: String? = null
    var createdAt: String? = null
    var text: String? = null

    var userId: String? = null
    var user: User? = null

    var fileId: String? = null
    var file: File? = null

    var recipientId: String? = null
    var recipient: User? = null

    var groupId: String? = null
    var group: Group? = null

    var read = false
    var reads: List<String>? = null
}