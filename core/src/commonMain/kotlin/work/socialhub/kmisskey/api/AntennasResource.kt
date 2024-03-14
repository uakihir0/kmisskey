package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.AntennasNotesRequest
import work.socialhub.kmisskey.api.response.AntennasListResponse
import work.socialhub.kmisskey.api.response.AntennasNotesResponse
import work.socialhub.kmisskey.entity.share.Response

interface AntennasResource {

    /**
     * ログイン中のユーザーが作成したアンテナの一覧を取得します。
     *
     * @see "https://misskey.io/api-doc.tag/antennas/operation/antennas/list"
     */
    fun list(): Response<Array<AntennasListResponse>>

    fun notes(request: AntennasNotesRequest): Response<Array<AntennasNotesResponse>>
}
