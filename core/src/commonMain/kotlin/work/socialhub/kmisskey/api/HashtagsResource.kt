package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.hashtags.HashtagsTrendRequest
import work.socialhub.kmisskey.api.response.hashtags.HashtagsTrendResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface HashtagsResource {

    /**
     * ハッシュタグのトレンドを取得します。
     * https://misskey.io/api-doc#operation/hashtags/trend
     */
    suspend fun trend(
        request: HashtagsTrendRequest
    ): Response<Array<HashtagsTrendResponse>>

    fun trendBlocking(
        request: HashtagsTrendRequest
    ): Response<Array<HashtagsTrendResponse>>
}
