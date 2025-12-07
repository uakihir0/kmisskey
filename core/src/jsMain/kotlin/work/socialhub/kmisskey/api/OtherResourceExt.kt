package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.other.ServiceWorkerRegisterRequest
import work.socialhub.kmisskey.api.response.other.ServiceWorkerRegisterResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for OtherResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun OtherResource.serviceWorkerRegisterPromise(
    request: ServiceWorkerRegisterRequest
): Promise<Response<ServiceWorkerRegisterResponse>> = GlobalScope.promise { serviceWorkerRegister(request) }

