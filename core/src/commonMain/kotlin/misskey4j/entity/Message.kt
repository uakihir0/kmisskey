package misskey4j.entity

import kotlinx.serialization.Serializable
import misskey4j.entity.user.User
import misskey4j.entity.user.UserLite

@Serializable
open class Message {

    var id: String? = null
    var createdAt: String? = null
    var text: String? = null

    var userId: String? = null
    var user: UserLite? = null

    var fileId: String? = null
    var file: File? = null

    var recipientId: String? = null
    var recipient: User? = null

    var groupId: String? = null
    var group: Group? = null

    var read = false
    var reads: List<String>? = null
}