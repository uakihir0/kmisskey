package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.MisskeyAPI.*
import misskey4j.api.WebhooksResource
import misskey4j.api.request.webhooks.*
import misskey4j.api.response.webhooks.CreateWebhooksResponse
import misskey4j.api.response.webhooks.DeleteWebhooksResponse
import misskey4j.api.response.webhooks.ShowWebhooksResponse
import misskey4j.api.response.webhooks.UpdateWebhooksResponse
import misskey4j.entity.share.Response

class WebhooksResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    WebhooksResource {

    /**
     * {@inheritDoc}
     */
    override fun create(
        request: CreateWebhooksRequest
    ): Response<CreateWebhooksResponse> {
        return post(IWebhooksCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun delete(
        request: DeleteWebhooksRequest
    ): Response<DeleteWebhooksResponse> {
        return post(IWebhooksDelete.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun list(
        request: ListWebhooksRequest
    ): Response<Array<ShowWebhooksResponse>> {
        return post(IWebhooksList.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun show(
        request: ShowWebhooksRequest
    ): Response<ShowWebhooksResponse> {
        return post(IWebhooksShow.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun update(
        request: UpdateWebhooksRequest
    ): Response<UpdateWebhooksResponse> {
        return post(IWebhooksUpdate.path, request)
    }
}
