package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.entity.share.Response

class FavoritesResourceImpl(uri: String, i: String?) : AbstractResourceImpl(uri, i), FavoritesResource {
    /**
     * {@inheritDoc}
     */
    override fun create(
        request: FavoritesCreateRequest?
    ): Response<java.lang.Void> {
        return post(MisskeyAPI.FavoritesCreate.code(), request)
    }

    /**
     * {@inheritDoc}
     */
    override fun delete(
        request: FavoritesDeleteRequest?
    ): Response<java.lang.Void> {
        return post(MisskeyAPI.FavoritesDelete.code(), request)
    }
}
