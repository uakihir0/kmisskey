package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.lists.*
import work.socialhub.kmisskey.api.response.lists.UsersListsListResponse
import work.socialhub.kmisskey.api.response.lists.UsersListsShowResponse
import work.socialhub.kmisskey.entity.NoteList
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface ListsResource {

    /**
     * 認証ユーザーの作成したユーザーリスト一覧を取得します。
     * @see "https://misskey.io/api-doc.operation/users/lists/list"
     */
    fun list(
        request: UsersListsListRequest
    ): Response<Array<UsersListsListResponse>>

    /**
     * 指定したユーザーリストの情報を取得します。
     *
     * @see "https://misskey.io/api-doc.operation/users/lists/show"
     */
    fun show(
        request: UsersListsShowRequest
    ): Response<UsersListsShowResponse>

    /**
     * 指定したユーザーをリストに追加します。
     * @see "https://misskey.io/api-doc.tag/lists/operation/users/lists/push"
     */
    fun push(
        request: UsersListsPushRequest
    ): Response<Unit>

    /**
     * 指定したユーザーをリストから削除します。
     * @see "https://misskey.io/api-doc.tag/lists/operation/users/lists/pull"
     */
    fun pull(
        request: UsersListsPullRequest
    ): Response<Unit>

    /**
     * リストを作成します。
     * @see "https://misskey.io/api-doc.tag/lists/operation/users/lists/create"
     */
    fun create(
        request: UsersListsCreateRequest
    ): Response<NoteList>

    /**
     * リストを更新します。
     * @see "https://misskey.io/api-doc.tag/lists/operation/users/lists/update"
     */
    fun update(
        request: UsersListsUpdateRequest
    ): Response<NoteList>

    /**
     * リストを削除します。
     * @see "https://misskey.io/api-doc.tag/lists/operation/users/lists/delete"
     */
    fun delete(
        request: UsersListsDeleteRequest
    ): Response<Unit>
}
