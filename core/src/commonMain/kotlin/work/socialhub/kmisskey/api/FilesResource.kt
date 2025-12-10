package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.files.FilesCreateRequest
import work.socialhub.kmisskey.api.request.files.FilesDeleteRequest
import work.socialhub.kmisskey.api.request.files.FilesFindRequest
import work.socialhub.kmisskey.api.request.files.FilesRequest
import work.socialhub.kmisskey.api.request.files.FilesShowRequest
import work.socialhub.kmisskey.api.request.files.FilesUpdateRequest
import work.socialhub.kmisskey.api.response.files.FilesCreateResponse
import work.socialhub.kmisskey.entity.File
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface FilesResource {

    /**
     * ドライブにファイルをアップロードします。
     * https://misskey.io/api-doc#operation/drive/files/create
     */
    @JsExport.Ignore
    suspend fun create(
        request: FilesCreateRequest
    ): Response<FilesCreateResponse>

    @JsExport.Ignore
    fun createBlocking(
        request: FilesCreateRequest
    ): Response<FilesCreateResponse>

    /**
     * ドライブのファイルを取得します。
     * https://misskey.io/api-doc#operation/drive/files/show
     */
    @JsExport.Ignore
    suspend fun show(
        request: FilesShowRequest
    ): Response<File>

    @JsExport.Ignore
    fun showBlocking(
        request: FilesShowRequest
    ): Response<File>

    /**
     * ドライブのファイル一覧を取得します。
     * https://misskey.io/api-doc#operation/drive/files
     */
    @JsExport.Ignore
    suspend fun list(
        request: FilesRequest
    ): Response<Array<File>>

    @JsExport.Ignore
    fun listBlocking(
        request: FilesRequest
    ): Response<Array<File>>

    /**
     * ドライブのファイルを検索します。
     * https://misskey.io/api-doc#operation/drive/files/find
     */
    @JsExport.Ignore
    suspend fun find(
        request: FilesFindRequest
    ): Response<Array<File>>

    @JsExport.Ignore
    fun findBlocking(
        request: FilesFindRequest
    ): Response<Array<File>>

    /**
     * ドライブのファイルを削除します。
     * https://misskey.io/api-doc#operation/drive/files/delete
     */
    @JsExport.Ignore
    suspend fun delete(
        request: FilesDeleteRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun deleteBlocking(
        request: FilesDeleteRequest
    ): EmptyResponse

    /**
     * ドライブのファイルを更新します。
     * https://misskey.io/api-doc#operation/drive/files/update
     */
    @JsExport.Ignore
    suspend fun update(
        request: FilesUpdateRequest
    ): Response<File>

    @JsExport.Ignore
    fun updateBlocking(
        request: FilesUpdateRequest
    ): Response<File>
}
