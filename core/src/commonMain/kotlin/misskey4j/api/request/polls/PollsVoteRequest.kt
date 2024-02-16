package misskey4j.api.request.polls

import misskey4j.api.model.TokenRequest

class PollsVoteRequest(
    i:String
) : TokenRequest(i) {

    var noteId: String? = null
    var choice: Int? = null
}
