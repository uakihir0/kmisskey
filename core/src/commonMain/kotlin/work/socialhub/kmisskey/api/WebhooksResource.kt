package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.webhooks.CreateWebhooksRequest
import work.socialhub.kmisskey.api.request.webhooks.DeleteWebhooksRequest
import work.socialhub.kmisskey.api.request.webhooks.ListWebhooksRequest
import work.socialhub.kmisskey.api.request.webhooks.ShowWebhooksRequest
import work.socialhub.kmisskey.api.request.webhooks.UpdateWebhooksRequest
import work.socialhub.kmisskey.api.response.webhooks.CreateWebhooksResponse
import work.socialhub.kmisskey.api.response.webhooks.DeleteWebhooksResponse
import work.socialhub.kmisskey.api.response.webhooks.ShowWebhooksResponse
import work.socialhub.kmisskey.api.response.webhooks.UpdateWebhooksResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface WebhooksResource {

    /**
     * Webhook を作成します。
     * https://misskey.io/api-doc#tag/webhooks/operation/i/webhooks/create
     */
    suspend fun create(
        request: CreateWebhooksRequest
    ): Response<CreateWebhooksResponse>

    fun createBlocking(
        request: CreateWebhooksRequest
    ): Response<CreateWebhooksResponse>

    /**
     * Webhook を削除します。
     * https://misskey.io/api-doc#tag/webhooks/operation/i/webhooks/delete
     */
    suspend fun delete(
        request: DeleteWebhooksRequest
    ): Response<DeleteWebhooksResponse>

    fun deleteBlocking(
        request: DeleteWebhooksRequest
    ): Response<DeleteWebhooksResponse>

    /**
     * ログイン中のユーザーが設定している Webhook の一覧を取得します。
     * https://misskey.io/api-doc#tag/webhooks/operation/i/webhooks/list
     */
    suspend fun list(
        request: ListWebhooksRequest
    ): Response<Array<ShowWebhooksResponse>>

    fun listBlocking(
        request: ListWebhooksRequest
    ): Response<Array<ShowWebhooksResponse>>

    /**
     * 与えられた id に対応する Webhook を取得します。
     * https://misskey.io/api-doc#tag/webhooks/operation/i/webhooks/show
     */
    suspend fun show(
        request: ShowWebhooksRequest
    ): Response<ShowWebhooksResponse>

    fun showBlocking(
        request: ShowWebhooksRequest
    ): Response<ShowWebhooksResponse>

    /**
     * Webhook の設定を更新します。
     * https://misskey.io/api-doc#tag/webhooks/operation/i/webhooks/update
     */
    suspend fun update(
        request: UpdateWebhooksRequest
    ): Response<UpdateWebhooksResponse>

    fun updateBlocking(
        request: UpdateWebhooksRequest
    ): Response<UpdateWebhooksResponse>
}
