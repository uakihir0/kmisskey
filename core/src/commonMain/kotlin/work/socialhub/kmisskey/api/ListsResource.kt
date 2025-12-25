package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.lists.UsersListsCreateRequest
import work.socialhub.kmisskey.api.request.lists.UsersListsDeleteRequest
import work.socialhub.kmisskey.api.request.lists.UsersListsListRequest
import work.socialhub.kmisskey.api.request.lists.UsersListsPullRequest
import work.socialhub.kmisskey.api.request.lists.UsersListsPushRequest
import work.socialhub.kmisskey.api.request.lists.UsersListsShowRequest
import work.socialhub.kmisskey.api.request.lists.UsersListsUpdateRequest
import work.socialhub.kmisskey.api.response.lists.UsersListsListResponse
import work.socialhub.kmisskey.api.response.lists.UsersListsShowResponse
import work.socialhub.kmisskey.entity.NoteList
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface ListsResource {

    /**
     * 認証ユーザーの作成したユーザーリスト一覧を取得します。
     * @see "https://misskey.io/api-doc.operation/users/lists/list"
     */
    suspend fun list(
        request: UsersListsListRequest
    ): Response<Array<UsersListsListResponse>>

    @JsExport.Ignore
    fun listBlocking(
        request: UsersListsListRequest
    ): Response<Array<UsersListsListResponse>>

    /**
     * 指定したユーザーリストの情報を取得します。
     *
     * @see "https://misskey.io/api-doc.operation/users/lists/show"
     */
    suspend fun show(
        request: UsersListsShowRequest
    ): Response<UsersListsShowResponse>

    @JsExport.Ignore
    fun showBlocking(
        request: UsersListsShowRequest
    ): Response<UsersListsShowResponse>

    /**
     * 指定したユーザーをリストに追加します。
     * @see "https://misskey.io/api-doc.tag/lists/operation/users/lists/push"
     */
    suspend fun push(
        request: UsersListsPushRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun pushBlocking(
        request: UsersListsPushRequest
    ): EmptyResponse

    /**
     * 指定したユーザーをリストから削除します。
     * @see "https://misskey.io/api-doc.tag/lists/operation/users/lists/pull"
     */
    suspend fun pull(
        request: UsersListsPullRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun pullBlocking(
        request: UsersListsPullRequest
    ): EmptyResponse

    /**
     * リストを作成します。
     * @see "https://misskey.io/api-doc.tag/lists/operation/users/lists/create"
     */
    suspend fun create(
        request: UsersListsCreateRequest
    ): Response<NoteList>

    @JsExport.Ignore
    fun createBlocking(
        request: UsersListsCreateRequest
    ): Response<NoteList>

    /**
     * リストを更新します。
     * @see "https://misskey.io/api-doc.tag/lists/operation/users/lists/update"
     */
    suspend fun update(
        request: UsersListsUpdateRequest
    ): Response<NoteList>

    @JsExport.Ignore
    fun updateBlocking(
        request: UsersListsUpdateRequest
    ): Response<NoteList>

    /**
     * リストを削除します。
     * @see "https://misskey.io/api-doc.tag/lists/operation/users/lists/delete"
     */
    suspend fun delete(
        request: UsersListsDeleteRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun deleteBlocking(
        request: UsersListsDeleteRequest
    ): EmptyResponse
}
