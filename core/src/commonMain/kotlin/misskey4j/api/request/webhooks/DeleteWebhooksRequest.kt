package misskey4j.api.request.webhooks

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class DeleteWebhooksRequest(
    override var i: String
) : TokenRequest() {

    var webhookId: String? = null
}
