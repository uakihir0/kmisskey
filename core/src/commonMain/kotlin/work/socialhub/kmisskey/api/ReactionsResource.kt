package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.reactions.ReactionsCreateRequest
import work.socialhub.kmisskey.api.request.reactions.ReactionsDeleteRequest
import work.socialhub.kmisskey.entity.share.EmptyResponse
import kotlin.js.JsExport

@JsExport
interface ReactionsResource {
    /**
     * 指定した投稿にリアクションします。
     * https://misskey.io/api-doc#operation/notes/reactions/create
     */
    fun create(
        request: ReactionsCreateRequest
    ): EmptyResponse

    /**
     * 指定した投稿へのリアクションを取り消します。
     * https://misskey.io/api-doc#operation/notes/reactions/delete
     */
    fun delete(
        request: ReactionsDeleteRequest
    ): EmptyResponse
}
