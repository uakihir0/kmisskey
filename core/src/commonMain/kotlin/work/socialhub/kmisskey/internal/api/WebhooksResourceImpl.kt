package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.IWebhooksCreate
import work.socialhub.kmisskey.MisskeyAPI.IWebhooksDelete
import work.socialhub.kmisskey.MisskeyAPI.IWebhooksList
import work.socialhub.kmisskey.MisskeyAPI.IWebhooksShow
import work.socialhub.kmisskey.MisskeyAPI.IWebhooksUpdate
import work.socialhub.kmisskey.api.WebhooksResource
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
