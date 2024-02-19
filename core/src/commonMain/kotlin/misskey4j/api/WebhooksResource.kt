package misskey4j.api

import misskey4j.api.request.webhooks.*
import misskey4j.api.response.webhooks.CreateWebhooksResponse
import misskey4j.api.response.webhooks.DeleteWebhooksResponse
import misskey4j.api.response.webhooks.ShowWebhooksResponse
import misskey4j.api.response.webhooks.UpdateWebhooksResponse
import misskey4j.entity.share.Response

interface WebhooksResource {
    /**
     * Webhook を作成します。
     * https://misskey.io/api-doc#tag/webhooks/operation/i/webhooks/create
     */
    fun create(
        request: CreateWebhooksRequest?
    ): Response<CreateWebhooksResponse?>?

    /**
     * Webhook を削除します。
     * https://misskey.io/api-doc#tag/webhooks/operation/i/webhooks/delete
     */
    fun delete(
        request: DeleteWebhooksRequest?
    ): Response<DeleteWebhooksResponse?>?

    /**
     * ログイン中のユーザーが設定している Webhook の一覧を取得します。
     * https://misskey.io/api-doc#tag/webhooks/operation/i/webhooks/list
     */
    fun list(
        request: ListWebhooksRequest?
    ): Response<Array<ShowWebhooksResponse?>?>?

    /**
     * 与えられた id に対応する Webhook を取得します。
     * https://misskey.io/api-doc#tag/webhooks/operation/i/webhooks/show
     */
    fun show(
        request: ShowWebhooksRequest?
    ): Response<ShowWebhooksResponse?>?

    /**
     * Webhook の設定を更新します。
     * https://misskey.io/api-doc#tag/webhooks/operation/i/webhooks/update
     */
    fun update(
        request: UpdateWebhooksRequest?
    ): Response<UpdateWebhooksResponse?>?
}
