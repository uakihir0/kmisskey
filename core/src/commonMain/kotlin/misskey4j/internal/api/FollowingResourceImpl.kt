package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.entity.share.Response

class FollowingResourceImpl(uri: String, i: String?) : AbstractResourceImpl(uri, i), FollowingResource {
    /**
     * {@inheritDoc}
     */
    override fun create(
        request: FollowingCreateRequest
    ): Response<java.lang.Void> {
        return post(MisskeyAPI.FollowingCreate.code(), request)
    }

    /**
     * {@inheritDoc}
     */
    override fun delete(
        request: FollowingDeleteRequest
    ): Response<java.lang.Void> {
        return post(MisskeyAPI.FollowingDelete.code(), request)
    }
}
