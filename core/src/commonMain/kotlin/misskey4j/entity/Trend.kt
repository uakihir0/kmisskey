package misskey4j.entity

import kotlinx.serialization.Serializable

@Serializable
open class Trend {
    var tag: String? = null
    var chart: List<Long>? = null
    var usersCount: Long? = null
}
