package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.RenoteMutesCreate
import work.socialhub.kmisskey.MisskeyAPI.RenoteMutesDelete
import work.socialhub.kmisskey.MisskeyAPI.RenoteMutesList
import work.socialhub.kmisskey.api.RenoteMutesResource
import work.socialhub.kmisskey.api.request.renotemutes.RenoteMutesCreateRequest
import work.socialhub.kmisskey.api.request.renotemutes.RenoteMutesDeleteRequest
import work.socialhub.kmisskey.api.request.renotemutes.RenoteMutesListRequest
import work.socialhub.kmisskey.api.response.renotemutes.RenoteMutesListResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.util.toBlocking

class RenoteMutesResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    RenoteMutesResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun create(
        request: RenoteMutesCreateRequest
    ): EmptyResponse {
        return postUnit(RenoteMutesCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun createBlocking(
        request: RenoteMutesCreateRequest
    ): EmptyResponse {
        return toBlocking {
            create(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun delete(
        request: RenoteMutesDeleteRequest
    ): EmptyResponse {
        return postUnit(RenoteMutesDelete.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun deleteBlocking(
        request: RenoteMutesDeleteRequest
    ): EmptyResponse {
        return toBlocking {
            delete(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun list(
        request: RenoteMutesListRequest
    ): Response<Array<RenoteMutesListResponse>> {
        return post(RenoteMutesList.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun listBlocking(
        request: RenoteMutesListRequest
    ): Response<Array<RenoteMutesListResponse>> {
        return toBlocking {
            list(request)
        }
    }
}
