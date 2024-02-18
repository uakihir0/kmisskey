package misskey4j.entity

import kotlinx.serialization.Serializable

@Serializable
class Mute {

    var id: String? = null
    var createdAt: String? = null

    var muteeId: String? = null
    var mutee: User? = null
}
