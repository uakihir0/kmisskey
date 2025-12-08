package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.files.FilesCreateRequest
import work.socialhub.kmisskey.api.response.files.FilesCreateResponse
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
}
