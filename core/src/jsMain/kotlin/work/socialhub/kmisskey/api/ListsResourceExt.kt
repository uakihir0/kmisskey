package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.lists.*
import work.socialhub.kmisskey.api.response.lists.UsersListsListResponse
import work.socialhub.kmisskey.api.response.lists.UsersListsShowResponse
import work.socialhub.kmisskey.entity.NoteList
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for ListsResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun ListsResource.listPromise(
    request: UsersListsListRequest
): Promise<Response<Array<UsersListsListResponse>>> = GlobalScope.promise { list(request) }

@OptIn(DelicateCoroutinesApi::class)
fun ListsResource.showPromise(
    request: UsersListsShowRequest
): Promise<Response<UsersListsShowResponse>> = GlobalScope.promise { show(request) }

@OptIn(DelicateCoroutinesApi::class)
fun ListsResource.pushPromise(
    request: UsersListsPushRequest
): Promise<EmptyResponse> = GlobalScope.promise { push(request) }

@OptIn(DelicateCoroutinesApi::class)
fun ListsResource.pullPromise(
    request: UsersListsPullRequest
): Promise<EmptyResponse> = GlobalScope.promise { pull(request) }

@OptIn(DelicateCoroutinesApi::class)
fun ListsResource.createPromise(
    request: UsersListsCreateRequest
): Promise<Response<NoteList>> = GlobalScope.promise { create(request) }

@OptIn(DelicateCoroutinesApi::class)
fun ListsResource.updatePromise(
    request: UsersListsUpdateRequest
): Promise<Response<NoteList>> = GlobalScope.promise { update(request) }

@OptIn(DelicateCoroutinesApi::class)
fun ListsResource.deletePromise(
    request: UsersListsDeleteRequest
): Promise<EmptyResponse> = GlobalScope.promise { delete(request) }

