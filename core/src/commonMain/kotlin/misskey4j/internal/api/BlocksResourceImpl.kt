package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.entity.share.Response

class BlocksResourceImpl(uri: String, i: String?) : AbstractResourceImpl(uri, i), BlocksResource {
    /**
     * {@inheritDoc}
     */
    override fun create(
        request: BlocksCreateRequest
    ): Response<java.lang.Void> {
        return post(MisskeyAPI.BlocksCreate.code(), request)
    }

    /**
     * {@inheritDoc}
     */
    override fun delete(
        request: BlocksDeleteRequest
    ): Response<java.lang.Void> {
        return post(MisskeyAPI.BlocksDelete.code(), request)
    }

    /**
     * {@inheritDoc}
     */
    override fun list(
        request: BlocksListRequest
    ): Response<Array<BlocksListResponse>> {
        return post(
            Array<BlocksListResponse>::class.java,
            MisskeyAPI.BlocksList.code(), request
        )
    }
}
