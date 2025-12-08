package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.hashtags.HashtagsTrendRequest
import work.socialhub.kmisskey.api.response.hashtags.HashtagsTrendResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for HashtagsResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun HashtagsResource.trendPromise(
    request: HashtagsTrendRequest
): Promise<Response<Array<HashtagsTrendResponse>>> = GlobalScope.promise { trend(request) }

