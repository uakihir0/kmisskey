package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.polls.PollsVoteRequest
import work.socialhub.kmisskey.entity.share.EmptyResponse
import kotlin.js.Promise

/**
 * Promise-based extensions for PollsResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun PollsResource.pollsVotePromise(
    request: PollsVoteRequest
): Promise<EmptyResponse> = GlobalScope.promise { pollsVote(request) }

