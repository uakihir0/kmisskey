package misskey4j.api.request.webhooks

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class UpdateWebhooksRequest : TokenRequest() {

    var webhookId: String? = null
    var name: String? = null
    var url: String? = null
    var on: List<String>? = null
    var secret: String? = null
    var active: Boolean? = null
}
