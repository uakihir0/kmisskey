package work.socialhub.kmisskey.api.model

import kotlinx.serialization.Serializable

@Serializable
class PollRequest {
    var choices: List<String>? = null
    var multiple: Boolean? = null
    var expiresAt: Long? = null
    var expiredAfter: Long? = null
}
