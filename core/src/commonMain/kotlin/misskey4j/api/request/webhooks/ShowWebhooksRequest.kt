package misskey4j.api.request.webhooks

import misskey4j.api.model.TokenRequest

class ShowWebhooksRequest(
    i:String
) : TokenRequest(i) {

    var webhookId: String? = null
}
