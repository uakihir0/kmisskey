package work.socialhub.kmisskey.api.request.webhooks

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class DeleteWebhooksRequest : TokenRequest() {

    var webhookId: String? = null
}
