package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.BlocksCreate
import work.socialhub.kmisskey.MisskeyAPI.BlocksDelete
import work.socialhub.kmisskey.MisskeyAPI.BlocksList
import work.socialhub.kmisskey.api.BlocksResource
import work.socialhub.kmisskey.api.request.blocks.BlocksCreateRequest
import work.socialhub.kmisskey.api.request.blocks.BlocksDeleteRequest
import work.socialhub.kmisskey.api.request.blocks.BlocksListRequest
import work.socialhub.kmisskey.api.response.blocks.BlocksListResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.util.toBlocking

class BlocksResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    BlocksResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun create(
        request: BlocksCreateRequest
    ): EmptyResponse {
        return postUnit(BlocksCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun createBlocking(
        request: BlocksCreateRequest
    ): EmptyResponse {
        return toBlocking {
            create(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun delete(
        request: BlocksDeleteRequest
    ): EmptyResponse {
        return postUnit(BlocksDelete.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun deleteBlocking(
        request: BlocksDeleteRequest
    ): EmptyResponse {
        return toBlocking {
            delete(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun list(
        request: BlocksListRequest
    ): Response<Array<BlocksListResponse>> {
        return post(BlocksList.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun listBlocking(
        request: BlocksListRequest
    ): Response<Array<BlocksListResponse>> {
        return toBlocking {
            list(request)
        }
    }
}
