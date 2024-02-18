package misskey4j.entity

import kotlinx.serialization.Serializable

@Serializable
class Poll {
    var multiple = false
    var expiresAt: String? = null
    var choices: List<Choice>? = null
}
