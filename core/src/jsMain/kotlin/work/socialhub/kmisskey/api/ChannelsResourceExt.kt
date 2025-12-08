package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.channels.*
import work.socialhub.kmisskey.api.response.channels.*
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for ChannelsResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun ChannelsResource.ownedPromise(
    request: ChannelsOwnedRequest
): Promise<Response<Array<ChannelsOwnedResponse>>> = GlobalScope.promise { owned(request) }

@OptIn(DelicateCoroutinesApi::class)
fun ChannelsResource.myFavoritesPromise(
    request: ChannelsMyFavoritesRequest
): Promise<Response<Array<ChannelsMyFavoritesResponse>>> = GlobalScope.promise { myFavorites(request) }

@OptIn(DelicateCoroutinesApi::class)
fun ChannelsResource.followedPromise(
    request: ChannelsFollowedRequest
): Promise<Response<Array<ChannelsFollowedResponse>>> = GlobalScope.promise { followed(request) }

@OptIn(DelicateCoroutinesApi::class)
fun ChannelsResource.timelinePromise(
    request: ChannelsTimelineRequest
): Promise<Response<Array<ChannelsTimelineResponse>>> = GlobalScope.promise { timeline(request) }

@OptIn(DelicateCoroutinesApi::class)
fun ChannelsResource.showPromise(
    request: ChannelsShowRequest
): Promise<Response<ChannelsShowResponse>> = GlobalScope.promise { show(request) }

