package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.federation.ShowInstanceRequest
import work.socialhub.kmisskey.api.response.federation.FederationInstanceResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for FederationResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun FederationResource.showInstancePromise(
    request: ShowInstanceRequest
): Promise<Response<FederationInstanceResponse>> = GlobalScope.promise { showInstance(request) }

