package misskey4j.entity

import kotlinx.serialization.Serializable

@Serializable
class Notification {
    lateinit var id: String
    lateinit var createdAt: String
    lateinit var type: String

    var user: User? = null
    var userId: String? = null
    var note: Note? = null

    var reaction: String? = null
    var choice: Long? = null

    // TODO parse invitation object
    var body: String? = null

    var header: String? = null
    var icon: String? = null
    var achievement: String? = null
}
