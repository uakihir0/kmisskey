package misskey4j.api

import misskey4j.api.request.ApShowRequest
import misskey4j.api.response.ApShowResponse
import misskey4j.entity.share.Response

interface ApResource {

    /**
     * 指定した uri の Note または User を取得します。
     * @see "https://misskey.io/api-doc.operation/ap/show"
     */
    fun show(
        request: ApShowRequest
    ): Response<ApShowResponse>
}
