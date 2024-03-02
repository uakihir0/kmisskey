package misskey4j.api.request.polls

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class PollsVoteRequest : TokenRequest() {

    var noteId: String? = null
    var choice: Int? = null
}
