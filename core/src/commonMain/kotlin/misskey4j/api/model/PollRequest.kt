package misskey4j.api.model

class PollRequest {
    var choices: List<String?>? = null
    var multiple: Boolean? = null
    var expiresAt: Long? = null
    var expiredAfter: Long? = null
}
