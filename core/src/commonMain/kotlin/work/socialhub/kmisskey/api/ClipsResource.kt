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
    @JsExport.Ignore
    suspend fun list(
        request: ClipsListRequest
    ): Response<Array<ClipsListResponse>>

    @JsExport.Ignore
    fun listBlocking(
        request: ClipsListRequest
    ): Response<Array<ClipsListResponse>>

    /**
     * クリップに含まれるノートを取得します。
     */
    @JsExport.Ignore
    suspend fun notes(
        request: ClipsNotesRequest
    ): Response<Array<ClipsNotesResponse>>

    @JsExport.Ignore
    fun notesBlocking(
        request: ClipsNotesRequest
    ): Response<Array<ClipsNotesResponse>>

    /**
     * ノートをクリップから削除します。
     *
     * @see "https://misskey.io/api-doc.tag/account/operation/clips/remove-note"
     */
    @JsExport.Ignore
    suspend fun removeNote(
        request: ClipsRemoveNoteRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun removeNoteBlocking(
        request: ClipsRemoveNoteRequest
    ): EmptyResponse

    /**
     * ノートをクリップに追加します。
     *
     * @see "https://misskey.io/api-doc.tag/account/operation/clips/add-note"
     */
    @JsExport.Ignore
    suspend fun addNote(
        request: ClipsAddNoteRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun addNoteBlocking(
        request: ClipsAddNoteRequest
    ): EmptyResponse

    /**
     * クリップを削除します。
     *
     * @see "https://misskey.io/api-doc.tag/clips/operation/clips/delete"
     */
    @JsExport.Ignore
    suspend fun deleteClip(
        request: ClipsDeleteRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun deleteClipBlocking(
        request: ClipsDeleteRequest
    ): EmptyResponse

    /**
     * クリップを作成します。
     *
     * @see "https://misskey.io/api-doc.tag/clips/operation/clips/create"
     */
    @JsExport.Ignore
    suspend fun create(
        request: ClipsCreateRequest
    ): Response<ClipsCreateResponse>

    @JsExport.Ignore
    fun createBlocking(
        request: ClipsCreateRequest
    ): Response<ClipsCreateResponse>

    /**
     * クリップを取得します。
     *
     * @see "https://misskey.io/api-doc.tag/clips/operation/clips/show"
     */
    @JsExport.Ignore
    suspend fun show(
        request: ClipsShowRequest
    ): Response<ClipsShowResponse>

    @JsExport.Ignore
    fun showBlocking(
        request: ClipsShowRequest
    ): Response<ClipsShowResponse>

    /**
     * クリップの情報を更新します。
     *
     * @see "https://misskey.io/api-doc.tag/clips/operation/clips/update"
     */
    @JsExport.Ignore
    suspend fun update(
        request: ClipsUpdateRequest
    ): Response<ClipsUpdateResponse>

    @JsExport.Ignore
    fun updateBlocking(
        request: ClipsUpdateRequest
    ): Response<ClipsUpdateResponse>
}
