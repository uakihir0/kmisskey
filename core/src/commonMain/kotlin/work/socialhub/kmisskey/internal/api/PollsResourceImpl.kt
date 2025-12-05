package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.PollsVote
import work.socialhub.kmisskey.api.PollsResource
import work.socialhub.kmisskey.api.request.polls.PollsVoteRequest
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.util.toBlocking

class PollsResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    PollsResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun pollsVote(
        request: PollsVoteRequest
    ): EmptyResponse {
        return postUnit(PollsVote.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun pollsVoteBlocking(
        request: PollsVoteRequest
    ): EmptyResponse {
        return toBlocking {
            pollsVote(request)
        }
    }
}
