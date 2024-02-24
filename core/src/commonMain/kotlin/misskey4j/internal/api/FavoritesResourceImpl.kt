package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.api.FavoritesResource
import misskey4j.api.request.favorites.FavoritesCreateRequest
import misskey4j.api.request.favorites.FavoritesDeleteRequest
import misskey4j.entity.share.Response

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
        return post(
            MisskeyAPI.FavoritesCreate.path,
            request
        )
    }

    /**
     * {@inheritDoc}
     */
    override fun delete(
        request: FavoritesDeleteRequest
    ): Response<Unit> {
        return post(
            MisskeyAPI.FavoritesDelete.path,
            request
        )
    }
}
