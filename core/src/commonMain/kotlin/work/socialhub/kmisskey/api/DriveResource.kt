package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.drive.DriveFilesRequest
import work.socialhub.kmisskey.api.request.drive.DriveFilesShowRequest
import work.socialhub.kmisskey.api.request.drive.DriveFoldersRequest
import work.socialhub.kmisskey.entity.File
import work.socialhub.kmisskey.entity.Folder
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface DriveResource {

    /**
     * ドライブのファイル一覧を取得します。
     *
     * https://misskey.io/api-doc#tag/drive/POST/drive/files
     */
    suspend fun files(
        request: DriveFilesRequest
    ): Response<Array<File>>

    @JsExport.Ignore
    fun filesBlocking(
        request: DriveFilesRequest
    ): Response<Array<File>>

    /**
     * ドライブのフォルダ一覧を取得します。
     *
     * https://misskey.io/api-doc#tag/drive/operation/drive/folders
     */
    suspend fun folders(
        request: DriveFoldersRequest
    ): Response<Array<Folder>>

    @JsExport.Ignore
    fun foldersBlocking(
        request: DriveFoldersRequest
    ): Response<Array<Folder>>

    /**
     * ドライブのファイル情報を取得します。
     *
     * https://misskey.io/api-doc#tag/drive/operation/drive/files/show
     */
    suspend fun showFile(
        request: DriveFilesShowRequest
    ): Response<File>

    @JsExport.Ignore
    fun showFileBlocking(
        request: DriveFilesShowRequest
    ): Response<File>
}
