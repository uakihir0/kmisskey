package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.CreateAppRequest
import work.socialhub.kmisskey.api.response.CreateAppResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for AppResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun AppResource.createAppPromise(
    request: CreateAppRequest
): Promise<Response<CreateAppResponse>> = GlobalScope.promise { createApp(request) }

