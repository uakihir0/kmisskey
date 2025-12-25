package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.ApShowRequest
import work.socialhub.kmisskey.api.response.ApShowResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface ApResource {

    /**
     * 指定した uri の Note または User を取得します。
     * @see "https://misskey.io/api-doc.operation/ap/show"
     */
    suspend fun show(
        request: ApShowRequest
    ): Response<ApShowResponse>

    @JsExport.Ignore
    fun showBlocking(
        request: ApShowRequest
    ): Response<ApShowResponse>
}
