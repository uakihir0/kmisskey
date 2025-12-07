package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.following.*
import work.socialhub.kmisskey.api.response.following.FollowingRequestsListResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for FollowingResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun FollowingResource.createPromise(
    request: FollowingCreateRequest
): Promise<EmptyResponse> = GlobalScope.promise { create(request) }

@OptIn(DelicateCoroutinesApi::class)
fun FollowingResource.deletePromise(
    request: FollowingDeleteRequest
): Promise<EmptyResponse> = GlobalScope.promise { delete(request) }

@OptIn(DelicateCoroutinesApi::class)
fun FollowingResource.requestsListPromise(
    request: FollowingRequestsListRequest
): Promise<Response<Array<FollowingRequestsListResponse>>> = GlobalScope.promise { requestsList(request) }

@OptIn(DelicateCoroutinesApi::class)
fun FollowingResource.acceptRequestPromise(
    request: FollowingRequestsAcceptRequest
): Promise<EmptyResponse> = GlobalScope.promise { acceptRequest(request) }

@OptIn(DelicateCoroutinesApi::class)
fun FollowingResource.rejectRequestPromise(
    request: FollowingRequestsRejectRequest
): Promise<EmptyResponse> = GlobalScope.promise { rejectRequest(request) }

