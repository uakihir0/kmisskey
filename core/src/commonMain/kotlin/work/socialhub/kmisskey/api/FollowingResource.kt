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
    @JsExport.Ignore
    suspend fun create(
        request: FollowingCreateRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun createBlocking(
        request: FollowingCreateRequest
    ): EmptyResponse

    /**
     * 指定したユーザーのフォローを解除します。
     * https://misskey.io/api-doc#operation/following/delete
     */
    @JsExport.Ignore
    suspend fun delete(
        request: FollowingDeleteRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun deleteBlocking(
        request: FollowingDeleteRequest
    ): EmptyResponse

    /**
     * フォローリクエストの一覧を取得します。
     * https://misskey.io/api-doc#tag/following/operation/following/requests/list
     */
    @JsExport.Ignore
    suspend fun requestsList(
        request: FollowingRequestsListRequest
    ): Response<Array<FollowingRequestsListResponse>>

    @JsExport.Ignore
    fun requestsListBlocking(
        request: FollowingRequestsListRequest
    ): Response<Array<FollowingRequestsListResponse>>

    /**
     * フォローを許可します。
     * https://misskey.io/api-doc#tag/following/operation/following/requests/accept
     */
    @JsExport.Ignore
    suspend fun acceptRequest(
        request: FollowingRequestsAcceptRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun acceptRequestBlocking(
        request: FollowingRequestsAcceptRequest
    ): EmptyResponse

    /**
     * フォローを拒否します。
     * https://misskey.io/api-doc#tag/following/operation/following/requests/reject
     */
    @JsExport.Ignore
    suspend fun rejectRequest(
        request: FollowingRequestsRejectRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun rejectRequestBlocking(
        request: FollowingRequestsRejectRequest
    ): EmptyResponse
}
