package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.mutes.MutesCreateRequest
import work.socialhub.kmisskey.api.request.mutes.MutesDeleteRequest
import work.socialhub.kmisskey.api.request.mutes.MutesListRequest
import work.socialhub.kmisskey.api.response.mutes.MutesListResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface MutesResource {

    /**
     * ユーザーをミュートします。
     * https://misskey.io/api-doc#operation/mute/create
     */
    suspend fun create(
        request: MutesCreateRequest
    ): EmptyResponse

    fun createBlocking(
        request: MutesCreateRequest
    ): EmptyResponse

    /**
     * ユーザーのミュートを解除します。
     * https://misskey.io/api-doc#operation/mute/delete
     */
    suspend fun delete(
        request: MutesDeleteRequest
    ): EmptyResponse

    fun deleteBlocking(
        request: MutesDeleteRequest
    ): EmptyResponse

    /**
     * ミュートしているユーザー一覧を取得します。
     * https://misskey.io/api-doc#operation/mute/list
     */
    suspend fun list(
        request: MutesListRequest
    ): Response<Array<MutesListResponse>>

    fun listBlocking(
        request: MutesListRequest
    ): Response<Array<MutesListResponse>>
}
