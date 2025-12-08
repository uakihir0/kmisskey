package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.reactions.ReactionsCreateRequest
import work.socialhub.kmisskey.api.request.reactions.ReactionsDeleteRequest
import work.socialhub.kmisskey.entity.share.EmptyResponse
import kotlin.js.Promise

/**
 * Promise-based extensions for ReactionsResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun ReactionsResource.createPromise(
    request: ReactionsCreateRequest
): Promise<EmptyResponse> = GlobalScope.promise { create(request) }

@OptIn(DelicateCoroutinesApi::class)
fun ReactionsResource.deletePromise(
    request: ReactionsDeleteRequest
): Promise<EmptyResponse> = GlobalScope.promise { delete(request) }

