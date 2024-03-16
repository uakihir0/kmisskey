package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.antennas.AntennasListRequest
import work.socialhub.kmisskey.api.request.antennas.AntennasNotesRequest
import work.socialhub.kmisskey.api.response.antennas.AntennasListResponse
import work.socialhub.kmisskey.api.response.antennas.AntennasNotesResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface AntennasResource {

    /**
     * ログイン中のユーザーが作成したアンテナの一覧を取得します。
     *
     * https://misskey.io/api-doc#tag/antennas/operation/antennas/list
     */
    fun list(
        request: AntennasListRequest
    ): Response<Array<AntennasListResponse>>

    /**
     * https://misskey.io/api-doc#tag/antennas/operation/antennas/notes
     */
    fun notes(
        request: AntennasNotesRequest
    ): Response<Array<AntennasNotesResponse>>
}
