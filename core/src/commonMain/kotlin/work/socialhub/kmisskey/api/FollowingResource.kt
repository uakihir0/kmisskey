package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.following.FollowingCreateRequest
import work.socialhub.kmisskey.api.request.following.FollowingDeleteRequest
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
    ): Response<Unit>

    /**
     * 指定したユーザーのフォローを解除します。
     * https://misskey.io/api-doc#operation/following/delete
     */
    fun delete(
        request: FollowingDeleteRequest
    ): Response<Unit>
}
