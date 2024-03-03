package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.*
import work.socialhub.kmisskey.api.BlocksResource
import work.socialhub.kmisskey.api.request.blocks.BlocksCreateRequest
import work.socialhub.kmisskey.api.request.blocks.BlocksDeleteRequest
import work.socialhub.kmisskey.api.request.blocks.BlocksListRequest
import work.socialhub.kmisskey.api.response.blocks.BlocksListResponse
import work.socialhub.kmisskey.entity.share.Response

class BlocksResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    BlocksResource {

    /**
     * {@inheritDoc}
     */
    override fun create(
        request: BlocksCreateRequest
    ): Response<Unit> {
        return post(BlocksCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun delete(
        request: BlocksDeleteRequest
    ): Response<Unit> {
        return post(BlocksDelete.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun list(
        request: BlocksListRequest
    ): Response<Array<BlocksListResponse>> {
        return post(BlocksList.path, request)
    }
}
