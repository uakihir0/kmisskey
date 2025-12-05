package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.ReactionsCreate
import work.socialhub.kmisskey.MisskeyAPI.ReactionsDelete
import work.socialhub.kmisskey.api.ReactionsResource
import work.socialhub.kmisskey.api.request.reactions.ReactionsCreateRequest
import work.socialhub.kmisskey.api.request.reactions.ReactionsDeleteRequest
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.util.toBlocking

class ReactionsResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    ReactionsResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun create(
        request: ReactionsCreateRequest
    ): EmptyResponse {
        return postUnit(ReactionsCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun createBlocking(
        request: ReactionsCreateRequest
    ): EmptyResponse {
        return toBlocking {
            create(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun delete(
        request: ReactionsDeleteRequest
    ): EmptyResponse {
        return postUnit(ReactionsDelete.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun deleteBlocking(
        request: ReactionsDeleteRequest
    ): EmptyResponse {
        return toBlocking {
            delete(request)
        }
    }
}
