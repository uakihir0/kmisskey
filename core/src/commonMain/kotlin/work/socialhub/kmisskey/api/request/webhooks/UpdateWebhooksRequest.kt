package work.socialhub.kmisskey.api.request.webhooks

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class UpdateWebhooksRequest : TokenRequest() {

    var webhookId: String? = null
    var name: String? = null
    var url: String? = null
    var on: List<String>? = null
    var secret: String? = null
    var active: Boolean? = null
}
