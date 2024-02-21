package misskey4j.api

import misskey4j.api.request.lists.*
import misskey4j.api.response.lists.UsersListsListResponse
import misskey4j.api.response.lists.UsersListsShowResponse
import misskey4j.entity.NoteList
import misskey4j.entity.share.Response

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
