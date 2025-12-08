package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.meta.EmojisRequest
import work.socialhub.kmisskey.api.request.meta.MetaRequest
import work.socialhub.kmisskey.api.response.meta.EmojisResponse
import work.socialhub.kmisskey.api.response.meta.GetOnlineUsersCountResponse
import work.socialhub.kmisskey.api.response.meta.MetaResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for MetaResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun MetaResource.metaPromise(
    request: MetaRequest
): Promise<Response<MetaResponse>> = GlobalScope.promise { meta(request) }

@OptIn(DelicateCoroutinesApi::class)
fun MetaResource.emojisPromise(
    request: EmojisRequest
): Promise<Response<EmojisResponse>> = GlobalScope.promise { emojis(request) }

@OptIn(DelicateCoroutinesApi::class)
fun MetaResource.getOnlineUsersCountPromise(
): Promise<Response<GetOnlineUsersCountResponse>> = GlobalScope.promise { getOnlineUsersCount() }

