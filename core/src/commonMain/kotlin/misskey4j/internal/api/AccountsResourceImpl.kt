package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.api.AccountsResource
import misskey4j.api.request.i.IFavoritesRequest
import misskey4j.api.request.i.INotificationsRequest
import misskey4j.api.request.i.IRequest
import misskey4j.api.response.i.IFavoritesResponse
import misskey4j.api.response.i.INotificationsResponse
import misskey4j.api.response.i.IResponse
import misskey4j.entity.share.Response

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
}
