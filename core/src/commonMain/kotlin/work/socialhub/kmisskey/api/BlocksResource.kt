package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.blocks.BlocksCreateRequest
import work.socialhub.kmisskey.api.request.blocks.BlocksDeleteRequest
import work.socialhub.kmisskey.api.request.blocks.BlocksListRequest
import work.socialhub.kmisskey.api.response.blocks.BlocksListResponse
import work.socialhub.kmisskey.entity.share.Response

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
