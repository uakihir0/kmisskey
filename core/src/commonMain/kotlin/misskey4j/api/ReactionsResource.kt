package misskey4j.api

import misskey4j.api.request.reactions.ReactionsCreateRequest
import misskey4j.api.request.reactions.ReactionsDeleteRequest
import misskey4j.entity.share.Response

interface ReactionsResource {
    /**
     * 指定した投稿にリアクションします。
     * https://misskey.io/api-doc#operation/notes/reactions/create
     */
    fun create(
        request: ReactionsCreateRequest
    ): Response<Unit>

    /**
     * 指定した投稿へのリアクションを取り消します。
     * https://misskey.io/api-doc#operation/notes/reactions/delete
     */
    fun delete(
        request: ReactionsDeleteRequest
    ): Response<Unit>
}
