package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.folders.FoldersCreateRequest
import work.socialhub.kmisskey.api.request.folders.FoldersDeleteRequest
import work.socialhub.kmisskey.api.request.folders.FoldersRequest
import work.socialhub.kmisskey.api.request.folders.FoldersShowRequest
import work.socialhub.kmisskey.api.request.folders.FoldersUpdateRequest
import work.socialhub.kmisskey.entity.Folder
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface FoldersResource {

    /**
     * ドライブにフォルダを作成します。
     * https://misskey.io/api-doc#operation/drive/folders/create
     */
    @JsExport.Ignore
    suspend fun create(
        request: FoldersCreateRequest
    ): Response<Folder>

    @JsExport.Ignore
    fun createBlocking(
        request: FoldersCreateRequest
    ): Response<Folder>

    /**
     * ドライブのフォルダ一覧を取得します。
     * https://misskey.io/api-doc#operation/drive/folders
     */
    @JsExport.Ignore
    suspend fun list(
        request: FoldersRequest
    ): Response<Array<Folder>>

    @JsExport.Ignore
    fun listBlocking(
        request: FoldersRequest
    ): Response<Array<Folder>>

    /**
     * ドライブのフォルダを取得します。
     * https://misskey.io/api-doc#operation/drive/folders/show
     */
    @JsExport.Ignore
    suspend fun show(
        request: FoldersShowRequest
    ): Response<Folder>

    @JsExport.Ignore
    fun showBlocking(
        request: FoldersShowRequest
    ): Response<Folder>

    /**
     * ドライブのフォルダを削除します。
     * https://misskey.io/api-doc#operation/drive/folders/delete
     */
    @JsExport.Ignore
    suspend fun delete(
        request: FoldersDeleteRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun deleteBlocking(
        request: FoldersDeleteRequest
    ): EmptyResponse

    /**
     * ドライブのフォルダを更新します。
     * https://misskey.io/api-doc#operation/drive/folders/update
     */
    @JsExport.Ignore
    suspend fun update(
        request: FoldersUpdateRequest
    ): Response<Folder>

    @JsExport.Ignore
    fun updateBlocking(
        request: FoldersUpdateRequest
    ): Response<Folder>
}
