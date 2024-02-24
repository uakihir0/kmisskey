package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.api.BlocksResource
import misskey4j.api.request.blocks.BlocksCreateRequest
import misskey4j.api.request.blocks.BlocksDeleteRequest
import misskey4j.api.request.blocks.BlocksListRequest
import misskey4j.api.response.blocks.BlocksListResponse
import misskey4j.entity.share.Response

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
        return post(
            MisskeyAPI.BlocksCreate.path,
            request
        )
    }

    /**
     * {@inheritDoc}
     */
    override fun delete(
        request: BlocksDeleteRequest
    ): Response<Unit> {
        return post(
            MisskeyAPI.BlocksDelete.path,
            request
        )
    }

    /**
     * {@inheritDoc}
     */
    override fun list(
        request: BlocksListRequest
    ): Response<Array<BlocksListResponse>> {
        return post(
            MisskeyAPI.BlocksList.path,
            request
        )
    }
}
