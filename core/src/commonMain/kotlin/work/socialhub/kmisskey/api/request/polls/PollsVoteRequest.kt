package work.socialhub.kmisskey.api.request.polls

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class PollsVoteRequest : TokenRequest() {

    var noteId: String? = null
    var choice: Int? = null
}
