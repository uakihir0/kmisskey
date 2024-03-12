package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI
import work.socialhub.kmisskey.api.AccountsResource
import work.socialhub.kmisskey.api.request.i.IFavoritesRequest
import work.socialhub.kmisskey.api.request.i.INotificationsRequest
import work.socialhub.kmisskey.api.request.i.IRequest
import work.socialhub.kmisskey.api.request.i.IUpdateRequest
import work.socialhub.kmisskey.api.response.i.IFavoritesResponse
import work.socialhub.kmisskey.api.response.i.INotificationsResponse
import work.socialhub.kmisskey.api.response.i.IResponse
import work.socialhub.kmisskey.api.response.i.IUpdateResponse
import work.socialhub.kmisskey.entity.share.Response

class AccountsResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    AccountsResource {

    /**
     * {@inheritDoc}
     */
    override fun i(
        request: IRequest
    ): Response<IResponse> {
        return post(MisskeyAPI.I.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun iFavorites(
        request: IFavoritesRequest
    ): Response<Array<IFavoritesResponse>> {
        return post(MisskeyAPI.IFavorites.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun iNotifications(
        request: INotificationsRequest
    ): Response<Array<INotificationsResponse>> {
        return post(MisskeyAPI.INotifications.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun iUpdate(request: IUpdateRequest): Response<IUpdateResponse> {
        return post(MisskeyAPI.IUpdate.path, request)
    }
}
