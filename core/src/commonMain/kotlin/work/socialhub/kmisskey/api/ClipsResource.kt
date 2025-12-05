package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.clips.ClipsAddNoteRequest
import work.socialhub.kmisskey.api.request.clips.ClipsCreateRequest
import work.socialhub.kmisskey.api.request.clips.ClipsDeleteRequest
import work.socialhub.kmisskey.api.request.clips.ClipsListRequest
import work.socialhub.kmisskey.api.request.clips.ClipsNotesRequest
import work.socialhub.kmisskey.api.request.clips.ClipsRemoveNoteRequest
import work.socialhub.kmisskey.api.request.clips.ClipsShowRequest
import work.socialhub.kmisskey.api.request.clips.ClipsUpdateRequest
import work.socialhub.kmisskey.api.response.clips.ClipsCreateResponse
import work.socialhub.kmisskey.api.response.clips.ClipsListResponse
import work.socialhub.kmisskey.api.response.clips.ClipsNotesResponse
import work.socialhub.kmisskey.api.response.clips.ClipsShowResponse
import work.socialhub.kmisskey.api.response.clips.ClipsUpdateResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport


@JsExport
interface ClipsResource {

    /**
     * ログイン中のユーザーが作成したクリップの一覧を取得します。
     *
     * https://misskey.io/api-doc#tag/clips/operation/clips/list
     */
    suspend fun list(
        request: ClipsListRequest
    ): Response<Array<ClipsListResponse>>

    fun listBlocking(
        request: ClipsListRequest
    ): Response<Array<ClipsListResponse>>

    /**
     * クリップに含まれるノートを取得します。
     */
    suspend fun notes(
        request: ClipsNotesRequest
    ): Response<Array<ClipsNotesResponse>>

    fun notesBlocking(
        request: ClipsNotesRequest
    ): Response<Array<ClipsNotesResponse>>

    /**
     * ノートをクリップから削除します。
     *
     * @see "https://misskey.io/api-doc.tag/account/operation/clips/remove-note"
     */
    suspend fun removeNote(
        request: ClipsRemoveNoteRequest
    ): EmptyResponse

    fun removeNoteBlocking(
        request: ClipsRemoveNoteRequest
    ): EmptyResponse

    /**
     * ノートをクリップに追加します。
     *
     * @see "https://misskey.io/api-doc.tag/account/operation/clips/add-note"
     */
    suspend fun addNote(
        request: ClipsAddNoteRequest
    ): EmptyResponse

    fun addNoteBlocking(
        request: ClipsAddNoteRequest
    ): EmptyResponse

    /**
     * クリップを削除します。
     *
     * @see "https://misskey.io/api-doc.tag/clips/operation/clips/delete"
     */
    suspend fun deleteClip(
        request: ClipsDeleteRequest
    ): EmptyResponse

    fun deleteClipBlocking(
        request: ClipsDeleteRequest
    ): EmptyResponse

    /**
     * クリップを作成します。
     *
     * @see "https://misskey.io/api-doc.tag/clips/operation/clips/create"
     */
    suspend fun create(
        request: ClipsCreateRequest
    ): Response<ClipsCreateResponse>

    fun createBlocking(
        request: ClipsCreateRequest
    ): Response<ClipsCreateResponse>

    /**
     * クリップを取得します。
     *
     * @see "https://misskey.io/api-doc.tag/clips/operation/clips/show"
     */
    suspend fun show(
        request: ClipsShowRequest
    ): Response<ClipsShowResponse>

    fun showBlocking(
        request: ClipsShowRequest
    ): Response<ClipsShowResponse>

    /**
     * クリップの情報を更新します。
     *
     * @see "https://misskey.io/api-doc.tag/clips/operation/clips/update"
     */
    suspend fun update(
        request: ClipsUpdateRequest
    ): Response<ClipsUpdateResponse>

    fun updateBlocking(
        request: ClipsUpdateRequest
    ): Response<ClipsUpdateResponse>
}
