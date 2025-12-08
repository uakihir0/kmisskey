package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI
import work.socialhub.kmisskey.api.AccountsResource
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
import work.socialhub.kmisskey.util.toBlocking

class AccountsResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    AccountsResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun i(
        request: IRequest
    ): Response<IResponse> {
        return post(MisskeyAPI.I.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun iBlocking(
        request: IRequest
    ): Response<IResponse> {
        return toBlocking {
            i(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun iFavorites(
        request: IFavoritesRequest
    ): Response<Array<IFavoritesResponse>> {
        return post(MisskeyAPI.IFavorites.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun iFavoritesBlocking(
        request: IFavoritesRequest
    ): Response<Array<IFavoritesResponse>> {
        return toBlocking {
            iFavorites(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun iNotifications(
        request: INotificationsRequest
    ): Response<Array<INotificationsResponse>> {
        return post(MisskeyAPI.INotifications.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun iNotificationsBlocking(
        request: INotificationsRequest
    ): Response<Array<INotificationsResponse>> {
        return toBlocking {
            iNotifications(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun iUpdate(
        request: IUpdateRequest
    ): Response<IUpdateResponse> {
        return post(MisskeyAPI.IUpdate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun iUpdateBlocking(
        request: IUpdateRequest
    ): Response<IUpdateResponse> {
        return toBlocking {
            iUpdate(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun pinNote(
        request: IPinRequest
    ): Response<IPinResponse> {
        return post(MisskeyAPI.IPin.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun pinNoteBlocking(
        request: IPinRequest
    ): Response<IPinResponse> {
        return toBlocking {
            pinNote(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun unpinNote(
        request: IUnpinRequest
    ): Response<IUnpinResponse> {
        return post(MisskeyAPI.IUnpin.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun unpinNoteBlocking(
        request: IUnpinRequest
    ): Response<IUnpinResponse> {
        return toBlocking {
            unpinNote(request)
        }
    }
}
