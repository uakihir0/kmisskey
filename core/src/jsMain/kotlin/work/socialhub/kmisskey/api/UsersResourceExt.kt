package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.users.*
import work.socialhub.kmisskey.api.response.notes.UsersReactionsResponse
import work.socialhub.kmisskey.api.response.users.*
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for UsersResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun UsersResource.followersPromise(
    request: UsersFollowersRequest
): Promise<Response<Array<UsersFollowersResponse>>> = GlobalScope.promise { followers(request) }

@OptIn(DelicateCoroutinesApi::class)
fun UsersResource.followingsPromise(
    request: UsersFollowingsRequest
): Promise<Response<Array<UsersFollowingsResponse>>> = GlobalScope.promise { followings(request) }

@OptIn(DelicateCoroutinesApi::class)
fun UsersResource.recommendationPromise(
    request: UsersRecommendationRequest
): Promise<Response<Array<UsersRecommendationResponse>>> = GlobalScope.promise { recommendation(request) }

@OptIn(DelicateCoroutinesApi::class)
fun UsersResource.showSinglePromise(
    request: UsersShowSingleRequest
): Promise<Response<UsersShowResponse>> = GlobalScope.promise { show(request) }

@OptIn(DelicateCoroutinesApi::class)
fun UsersResource.showMultiplePromise(
    request: UsersShowMultipleRequest
): Promise<Response<Array<UsersShowResponse>>> = GlobalScope.promise { show(request) }

@OptIn(DelicateCoroutinesApi::class)
fun UsersResource.reactionsPromise(
    request: UsersReactionsRequest
): Promise<Response<Array<UsersReactionsResponse>>> = GlobalScope.promise { reactions(request) }

@OptIn(DelicateCoroutinesApi::class)
fun UsersResource.relationPromise(
    request: UsersRelationRequest
): Promise<Response<Array<UsersRelationResponse>>> = GlobalScope.promise { relation(request) }

@OptIn(DelicateCoroutinesApi::class)
fun UsersResource.searchPromise(
    request: UsersSearchRequest
): Promise<Response<Array<UsersSearchResponse>>> = GlobalScope.promise { search(request) }

@OptIn(DelicateCoroutinesApi::class)
fun UsersResource.searchByUsernameAndHostPromise(
    request: UsersSearchByUsernameAndHostRequest
): Promise<Response<Array<UsersSearchByUsernameAndHostResponse>>> = GlobalScope.promise { searchByUsernameAndHost(request) }

