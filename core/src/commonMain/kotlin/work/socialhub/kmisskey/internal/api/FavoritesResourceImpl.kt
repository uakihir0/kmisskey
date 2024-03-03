package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.FavoritesCreate
import work.socialhub.kmisskey.MisskeyAPI.FavoritesDelete
import work.socialhub.kmisskey.api.FavoritesResource
import work.socialhub.kmisskey.api.request.favorites.FavoritesCreateRequest
import work.socialhub.kmisskey.api.request.favorites.FavoritesDeleteRequest
import work.socialhub.kmisskey.entity.share.Response

class FavoritesResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    FavoritesResource {

    /**
     * {@inheritDoc}
     */
    override fun create(
        request: FavoritesCreateRequest
    ): Response<Unit> {
        return post(FavoritesCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun delete(
        request: FavoritesDeleteRequest
    ): Response<Unit> {
        return post(FavoritesDelete.path, request)
    }
}
