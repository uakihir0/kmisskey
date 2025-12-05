package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.blocks.BlocksCreateRequest
import work.socialhub.kmisskey.api.request.blocks.BlocksDeleteRequest
import work.socialhub.kmisskey.api.request.blocks.BlocksListRequest
import work.socialhub.kmisskey.api.response.blocks.BlocksListResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface BlocksResource {

    /**
     * 指定したユーザーをブロックします。
     * https://misskey.io/api-doc#operation/blocking/create
     */
    suspend fun create(
        request: BlocksCreateRequest
    ): EmptyResponse

    fun createBlocking(
        request: BlocksCreateRequest
    ): EmptyResponse

    /**
     * 指定したユーザーのブロックを解除します。
     * https://misskey.io/api-doc#operation/blocking/delete
     */
    suspend fun delete(
        request: BlocksDeleteRequest
    ): EmptyResponse

    fun deleteBlocking(
        request: BlocksDeleteRequest
    ): EmptyResponse

    /**
     * ブロックしているユーザー一覧を取得します。
     * https://misskey.io/api-doc#operation/blocking/list
     */
    suspend fun list(
        request: BlocksListRequest
    ): Response<Array<BlocksListResponse>>

    fun listBlocking(
        request: BlocksListRequest
    ): Response<Array<BlocksListResponse>>
}
