package misskey4j.api

import misskey4j.api.request.meta.EmojisRequest
import misskey4j.api.request.meta.MetaRequest
import misskey4j.api.response.meta.EmojisResponse
import misskey4j.api.response.meta.MetaResponse
import misskey4j.entity.share.Response

interface MetaResource {
    /**
     * インスタンス情報を取得します。
     * https://misskey.io/api-doc#operation/meta
     */
    fun meta(
        request: MetaRequest
    ): Response<MetaResponse>

    /**
     * (from v13)
     * 絵文字情報を取得します。
     */
    fun emojis(
        request: EmojisRequest
    ): Response<EmojisResponse>
}
