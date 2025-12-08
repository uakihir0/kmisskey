package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.blocks.BlocksCreateRequest
import work.socialhub.kmisskey.api.request.blocks.BlocksDeleteRequest
import work.socialhub.kmisskey.api.request.blocks.BlocksListRequest
import work.socialhub.kmisskey.api.response.blocks.BlocksListResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for BlocksResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun BlocksResource.createPromise(
    request: BlocksCreateRequest
): Promise<EmptyResponse> = GlobalScope.promise { create(request) }

@OptIn(DelicateCoroutinesApi::class)
fun BlocksResource.deletePromise(
    request: BlocksDeleteRequest
): Promise<EmptyResponse> = GlobalScope.promise { delete(request) }

@OptIn(DelicateCoroutinesApi::class)
fun BlocksResource.listPromise(
    request: BlocksListRequest
): Promise<Response<Array<BlocksListResponse>>> = GlobalScope.promise { list(request) }

