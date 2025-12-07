package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.i.IFavoritesRequest
import work.socialhub.kmisskey.api.request.i.INotificationsRequest
import work.socialhub.kmisskey.api.request.i.IPinRequest
import work.socialhub.kmisskey.api.request.i.IRequest
import work.socialhub.kmisskey.api.request.i.IUnpinRequest
import work.socialhub.kmisskey.api.request.i.IUpdateRequest
import work.socialhub.kmisskey.api.response.i.IFavoritesResponse
import work.socialhub.kmisskey.api.response.i.INotificationsResponse
import work.socialhub.kmisskey.api.response.i.IPinResponse
import work.socialhub.kmisskey.api.response.i.IResponse
import work.socialhub.kmisskey.api.response.i.IUnpinResponse
import work.socialhub.kmisskey.api.response.i.IUpdateResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for AccountsResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun AccountsResource.iPromise(
    request: IRequest
): Promise<Response<IResponse>> = GlobalScope.promise { i(request) }

@OptIn(DelicateCoroutinesApi::class)
fun AccountsResource.iFavoritesPromise(
    request: IFavoritesRequest
): Promise<Response<Array<IFavoritesResponse>>> = GlobalScope.promise { iFavorites(request) }

@OptIn(DelicateCoroutinesApi::class)
fun AccountsResource.iNotificationsPromise(
    request: INotificationsRequest
): Promise<Response<Array<INotificationsResponse>>> = GlobalScope.promise { iNotifications(request) }

@OptIn(DelicateCoroutinesApi::class)
fun AccountsResource.iUpdatePromise(
    request: IUpdateRequest
): Promise<Response<IUpdateResponse>> = GlobalScope.promise { iUpdate(request) }

@OptIn(DelicateCoroutinesApi::class)
fun AccountsResource.pinNotePromise(
    request: IPinRequest
): Promise<Response<IPinResponse>> = GlobalScope.promise { pinNote(request) }

@OptIn(DelicateCoroutinesApi::class)
fun AccountsResource.unpinNotePromise(
    request: IUnpinRequest
): Promise<Response<IUnpinResponse>> = GlobalScope.promise { unpinNote(request) }

