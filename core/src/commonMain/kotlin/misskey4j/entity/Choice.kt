package misskey4j.entity

import kotlinx.serialization.Serializable

@Serializable
class Choice {

    var text: String? = null
    var votes: Long? = null
    var voted = false
}

