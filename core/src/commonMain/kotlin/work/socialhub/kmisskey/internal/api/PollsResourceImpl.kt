package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.PollsVote
import work.socialhub.kmisskey.api.PollsResource
import work.socialhub.kmisskey.api.request.polls.PollsVoteRequest
import work.socialhub.kmisskey.entity.share.Response

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
