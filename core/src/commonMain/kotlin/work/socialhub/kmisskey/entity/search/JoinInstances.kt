package work.socialhub.kmisskey.entity.search

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class JoinInstances {
    @SerialName("date")
    var timestamp: String? = null

    @SerialName("instancesInfos")
    var instances: List<JoinInstance>? = null
}
