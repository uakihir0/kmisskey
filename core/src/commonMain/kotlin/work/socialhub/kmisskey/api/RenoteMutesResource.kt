package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.renotemutes.RenoteMutesCreateRequest
import work.socialhub.kmisskey.api.request.renotemutes.RenoteMutesDeleteRequest
import work.socialhub.kmisskey.api.request.renotemutes.RenoteMutesListRequest
import work.socialhub.kmisskey.api.response.renotemutes.RenoteMutesListResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface RenoteMutesResource {

    /**
     * ユーザーのRenoteをミュートします。
     * https://misskey.io/api-doc#tag/account/POST/renote-mute/create
     */
    suspend fun create(
        request: RenoteMutesCreateRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun createBlocking(
        request: RenoteMutesCreateRequest
    ): EmptyResponse

    /**
     * ユーザーのRenoteのミュートを解除します。
     * https://misskey.io/api-doc#tag/account/POST/renote-mute/delete
     */
    suspend fun delete(
        request: RenoteMutesDeleteRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun deleteBlocking(
        request: RenoteMutesDeleteRequest
    ): EmptyResponse

    /**
     * Renoteをミュートしているユーザー一覧を取得します。
     * https://misskey.io/api-doc#tag/account/POST/renote-mute/list
     */
    suspend fun list(
        request: RenoteMutesListRequest
    ): Response<Array<RenoteMutesListResponse>>

    @JsExport.Ignore
    fun listBlocking(
        request: RenoteMutesListRequest
    ): Response<Array<RenoteMutesListResponse>>
}
