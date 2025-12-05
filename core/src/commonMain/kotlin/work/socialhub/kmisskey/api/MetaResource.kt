package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.meta.EmojisRequest
import work.socialhub.kmisskey.api.request.meta.MetaRequest
import work.socialhub.kmisskey.api.response.meta.EmojisResponse
import work.socialhub.kmisskey.api.response.meta.GetOnlineUsersCountResponse
import work.socialhub.kmisskey.api.response.meta.MetaResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface MetaResource {
    /**
     * インスタンス情報を取得します。
     * https://misskey.io/api-doc#operation/meta
     */
    suspend fun meta(
        request: MetaRequest
    ): Response<MetaResponse>

    fun metaBlocking(
        request: MetaRequest
    ): Response<MetaResponse>

    /**
     * (from v13)
     * 絵文字情報を取得します。
     */
    suspend fun emojis(
        request: EmojisRequest
    ): Response<EmojisResponse>

    fun emojisBlocking(
        request: EmojisRequest
    ): Response<EmojisResponse>

    /**
     * オンラインになっているユーザ数を取得します。
     */
    suspend fun getOnlineUsersCount(
    ): Response<GetOnlineUsersCountResponse>

    fun getOnlineUsersCountBlocking(
    ): Response<GetOnlineUsersCountResponse>
}
