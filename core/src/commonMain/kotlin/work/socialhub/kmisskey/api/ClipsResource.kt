package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.clips.ClipsCreateRequest
import work.socialhub.kmisskey.api.response.clips.ClipsCreateResponse
import work.socialhub.kmisskey.api.response.clips.ClipsListResponse
import work.socialhub.kmisskey.api.response.clips.ClipsNotesResponse
import work.socialhub.kmisskey.api.response.clips.ClipsShowResponse
import work.socialhub.kmisskey.api.response.clips.ClipsUpdateResponse
import work.socialhub.kmisskey.api.request.clips.ClipsNotesRequest
import work.socialhub.kmisskey.api.request.clips.ClipsUpdateRequest
import work.socialhub.kmisskey.entity.share.Response


interface ClipsResource {
    /**
     * ログイン中のユーザーが作成したクリップの一覧を取得します。
     *
     * @see "https://misskey.io/api-doc.tag/clips/operation/clips/list"
     */
    fun list(): Response<Array<ClipsListResponse>>

    /**
     * クリップに含まれるノートを取得します。
     */
    fun notes(request: ClipsNotesRequest): Response<Array<ClipsNotesResponse>>

    /**
     * ノートをクリップから削除します。
     *
     * @see "https://misskey.io/api-doc.tag/account/operation/clips/remove-note"
     */
    fun removeNote(clipId: String, noteId: String): Response<Unit>

    /**
     * ノートをクリップに追加します。
     *
     * @see "https://misskey.io/api-doc.tag/account/operation/clips/add-note"
     */
    fun addNote(clipId: String, noteId: String): Response<Unit>

    /**
     * クリップを削除します。
     *
     * @see "https://misskey.io/api-doc.tag/clips/operation/clips/delete"
     */
    fun deleteClip(clipId: String): Response<Unit>

    /**
     * クリップを作成します。
     *
     * @see "https://misskey.io/api-doc.tag/clips/operation/clips/create"
     */
    fun create(request: ClipsCreateRequest): Response<ClipsCreateResponse>

    /**
     * クリップを取得します。
     *
     * @see "https://misskey.io/api-doc.tag/clips/operation/clips/show"
     */
    fun show(clipId: String): Response<ClipsShowResponse>

    /**
     * クリップの情報を更新します。
     *
     * @see "https://misskey.io/api-doc.tag/clips/operation/clips/update"
     */
    fun update(request: ClipsUpdateRequest): Response<ClipsUpdateResponse>
}
