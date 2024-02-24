package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.api.FollowingResource
import misskey4j.api.request.following.FollowingCreateRequest
import misskey4j.api.request.following.FollowingDeleteRequest
import misskey4j.entity.share.Response

class FollowingResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    FollowingResource {

    /**
     * {@inheritDoc}
     */
    override fun create(
        request: FollowingCreateRequest
    ): Response<Unit> {
        return post(
            MisskeyAPI.FollowingCreate.path,
            request
        )
    }

    /**
     * {@inheritDoc}
     */
    override fun delete(
        request: FollowingDeleteRequest
    ): Response<Unit> {
        return post(
            MisskeyAPI.FollowingDelete.path,
            request
        )
    }
}
