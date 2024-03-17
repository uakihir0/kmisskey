package work.socialhub.kmisskey.api.request.webhooks

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class CreateWebhooksRequest : TokenRequest() {

    var name: String? = null
    var url: String? = null
    var on: Array<String>? = null
    var secret: String? = null
}
