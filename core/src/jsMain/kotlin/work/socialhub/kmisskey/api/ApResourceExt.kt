package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.ApShowRequest
import work.socialhub.kmisskey.api.response.ApShowResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for ApResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun ApResource.showPromise(
    request: ApShowRequest
): Promise<Response<ApShowResponse>> = GlobalScope.promise { show(request) }

