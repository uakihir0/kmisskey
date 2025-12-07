package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.webhooks.*
import work.socialhub.kmisskey.api.response.webhooks.CreateWebhooksResponse
import work.socialhub.kmisskey.api.response.webhooks.DeleteWebhooksResponse
import work.socialhub.kmisskey.api.response.webhooks.ShowWebhooksResponse
import work.socialhub.kmisskey.api.response.webhooks.UpdateWebhooksResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for WebhooksResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun WebhooksResource.createPromise(
    request: CreateWebhooksRequest
): Promise<Response<CreateWebhooksResponse>> = GlobalScope.promise { create(request) }

@OptIn(DelicateCoroutinesApi::class)
fun WebhooksResource.deletePromise(
    request: DeleteWebhooksRequest
): Promise<Response<DeleteWebhooksResponse>> = GlobalScope.promise { delete(request) }

@OptIn(DelicateCoroutinesApi::class)
fun WebhooksResource.listPromise(
    request: ListWebhooksRequest
): Promise<Response<Array<ShowWebhooksResponse>>> = GlobalScope.promise { list(request) }

@OptIn(DelicateCoroutinesApi::class)
fun WebhooksResource.showPromise(
    request: ShowWebhooksRequest
): Promise<Response<ShowWebhooksResponse>> = GlobalScope.promise { show(request) }

@OptIn(DelicateCoroutinesApi::class)
fun WebhooksResource.updatePromise(
    request: UpdateWebhooksRequest
): Promise<Response<UpdateWebhooksResponse>> = GlobalScope.promise { update(request) }

