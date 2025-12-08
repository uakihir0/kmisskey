package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.MutesCreate
import work.socialhub.kmisskey.MisskeyAPI.MutesDelete
import work.socialhub.kmisskey.MisskeyAPI.MutesList
import work.socialhub.kmisskey.api.MutesResource
import work.socialhub.kmisskey.api.request.mutes.MutesCreateRequest
import work.socialhub.kmisskey.api.request.mutes.MutesDeleteRequest
import work.socialhub.kmisskey.api.request.mutes.MutesListRequest
import work.socialhub.kmisskey.api.response.mutes.MutesListResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.util.toBlocking

class MutesResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    MutesResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun create(
        request: MutesCreateRequest
    ): EmptyResponse {
        return postUnit(MutesCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun createBlocking(
        request: MutesCreateRequest
    ): EmptyResponse {
        return toBlocking {
            create(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun delete(
        request: MutesDeleteRequest
    ): EmptyResponse {
        return postUnit(MutesDelete.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun deleteBlocking(
        request: MutesDeleteRequest
    ): EmptyResponse {
        return toBlocking {
            delete(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun list(
        request: MutesListRequest
    ): Response<Array<MutesListResponse>> {
        return post(MutesList.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun listBlocking(
        request: MutesListRequest
    ): Response<Array<MutesListResponse>> {
        return toBlocking {
            list(request)
        }
    }
}
