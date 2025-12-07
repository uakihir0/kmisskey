package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.mutes.MutesCreateRequest
import work.socialhub.kmisskey.api.request.mutes.MutesDeleteRequest
import work.socialhub.kmisskey.api.request.mutes.MutesListRequest
import work.socialhub.kmisskey.api.response.mutes.MutesListResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for MutesResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun MutesResource.createPromise(
    request: MutesCreateRequest
): Promise<EmptyResponse> = GlobalScope.promise { create(request) }

@OptIn(DelicateCoroutinesApi::class)
fun MutesResource.deletePromise(
    request: MutesDeleteRequest
): Promise<EmptyResponse> = GlobalScope.promise { delete(request) }

@OptIn(DelicateCoroutinesApi::class)
fun MutesResource.listPromise(
    request: MutesListRequest
): Promise<Response<Array<MutesListResponse>>> = GlobalScope.promise { list(request) }

