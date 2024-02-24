package misskey4j.internal.api

import misskey4j.MisskeyAPI.PollsVote
import misskey4j.api.PollsResource
import misskey4j.api.request.polls.PollsVoteRequest
import misskey4j.entity.share.Response

class PollsResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    PollsResource {

    /**
     * {@inheritDoc}
     */
    override fun pollsVote(
        request: PollsVoteRequest
    ): Response<Unit> {
        return post(PollsVote.path, request)
    }
}
