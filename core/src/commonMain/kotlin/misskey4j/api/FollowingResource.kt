package misskey4j.api

import misskey4j.api.request.following.FollowingCreateRequest
import misskey4j.api.request.following.FollowingDeleteRequest
import misskey4j.entity.share.Response

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
