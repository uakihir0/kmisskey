package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.following.FollowingCreateRequest
import work.socialhub.kmisskey.api.request.following.FollowingDeleteRequest
import work.socialhub.kmisskey.api.request.following.FollowingRequestsAcceptRequest
import work.socialhub.kmisskey.api.request.following.FollowingRequestsListRequest
import work.socialhub.kmisskey.api.request.following.FollowingRequestsRejectRequest
import work.socialhub.kmisskey.api.response.following.FollowingRequestsListResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface FollowingResource {

    /**
     * 指定したユーザーをフォローします。
     * https://misskey.io/api-doc#operation/following/create
     */
    fun create(
        request: FollowingCreateRequest
    ): EmptyResponse

    /**
     * 指定したユーザーのフォローを解除します。
     * https://misskey.io/api-doc#operation/following/delete
     */
    fun delete(
        request: FollowingDeleteRequest
    ): EmptyResponse

    /**
     * フォローリクエストの一覧を取得します。
     * https://misskey.io/api-doc#tag/following/operation/following/requests/list
     */
    fun requestsList(
        request: FollowingRequestsListRequest
    ): Response<Array<FollowingRequestsListResponse>>

    /**
     * フォローを許可します。
     * https://misskey.io/api-doc#tag/following/operation/following/requests/accept
     */
    fun acceptRequest(
        request: FollowingRequestsAcceptRequest
    ): EmptyResponse

    /**
     * フォローを拒否します。
     * https://misskey.io/api-doc#tag/following/operation/following/requests/reject
     */
    fun rejectRequest(
        request: FollowingRequestsRejectRequest
    ): EmptyResponse
}
