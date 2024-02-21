package misskey4j.api

import misskey4j.api.request.mutes.MutesCreateRequest
import misskey4j.api.request.mutes.MutesDeleteRequest
import misskey4j.api.request.mutes.MutesListRequest
import misskey4j.api.response.mutes.MutesListResponse
import misskey4j.entity.share.Response

interface MutesResource {
    /**
     * ユーザーをミュートします。
     * https://misskey.io/api-doc#operation/mute/create
     */
    fun create(
        request: MutesCreateRequest
    ): Response<Unit>

    /**
     * ユーザーのミュートを解除します。
     * https://misskey.io/api-doc#operation/mute/delete
     */
    fun delete(
        request: MutesDeleteRequest
    ): Response<Unit>

    /**
     * ミュートしているユーザー一覧を取得します。
     * https://misskey.io/api-doc#operation/mute/list
     */
    fun list(
        request: MutesListRequest
    ): Response<Array<MutesListResponse>>
}
