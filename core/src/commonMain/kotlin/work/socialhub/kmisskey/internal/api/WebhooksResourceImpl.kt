package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.*
import work.socialhub.kmisskey.api.WebhooksResource
import work.socialhub.kmisskey.api.request.webhooks.*
import work.socialhub.kmisskey.api.response.webhooks.CreateWebhooksResponse
import work.socialhub.kmisskey.api.response.webhooks.DeleteWebhooksResponse
import work.socialhub.kmisskey.api.response.webhooks.ShowWebhooksResponse
import work.socialhub.kmisskey.api.response.webhooks.UpdateWebhooksResponse
import work.socialhub.kmisskey.entity.share.Response

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
