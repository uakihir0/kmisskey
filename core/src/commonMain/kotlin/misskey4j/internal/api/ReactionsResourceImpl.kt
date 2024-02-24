package misskey4j.internal.api

import misskey4j.MisskeyAPI.ReactionsCreate
import misskey4j.MisskeyAPI.ReactionsDelete
import misskey4j.api.ReactionsResource
import misskey4j.api.request.reactions.ReactionsCreateRequest
import misskey4j.api.request.reactions.ReactionsDeleteRequest
import misskey4j.entity.share.Response

class ReactionsResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    ReactionsResource {

    /**
     * {@inheritDoc}
     */
    override fun create(
        request: ReactionsCreateRequest
    ): Response<Unit> {
        return post(ReactionsCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun delete(
        request: ReactionsDeleteRequest
    ): Response<Unit> {
        return post(ReactionsDelete.path, request)
    }
}
