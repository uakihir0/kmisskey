package work.socialhub.kmisskey.api.response.webhooks

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.Webhook
import kotlin.js.JsExport

@JsExport
@Serializable
class CreateWebhooksResponse : Webhook()

