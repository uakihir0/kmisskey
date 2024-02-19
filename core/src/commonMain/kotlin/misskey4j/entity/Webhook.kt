package misskey4j.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
open class Webhook {

    var id: String? = null
    var createdAt: Instant? = null
    var userId: String? = null
    var name: String? = null
    var on: List<String>? = null
    var url: String? = null
    var secret: String? = null
    var active: Boolean? = null
    var latestSentAt: Instant? = null
    var latestStatus: Long? = null
}
