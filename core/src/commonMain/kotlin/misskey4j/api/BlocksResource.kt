package misskey4j.api

import misskey4j.api.request.blocks.BlocksCreateRequest
import misskey4j.api.request.blocks.BlocksDeleteRequest
import misskey4j.api.request.blocks.BlocksListRequest
import misskey4j.api.response.blocks.BlocksListResponse
import misskey4j.entity.share.Response

interface BlocksResource {
    /**
     * 指定したユーザーをブロックします。
     * https://misskey.io/api-doc#operation/blocking/create
     */
    fun create(
        request: BlocksCreateRequest
    ): Response<Unit>

    /**
     * 指定したユーザーのブロックを解除します。
     * https://misskey.io/api-doc#operation/blocking/delete
     */
    fun delete(
        request: BlocksDeleteRequest
    ): Response<Unit>

    /**
     * ブロックしているユーザー一覧を取得します。
     * https://misskey.io/api-doc#operation/blocking/list
     */
    fun list(
        request: BlocksListRequest
    ): Response<Array<BlocksListResponse>>
}
