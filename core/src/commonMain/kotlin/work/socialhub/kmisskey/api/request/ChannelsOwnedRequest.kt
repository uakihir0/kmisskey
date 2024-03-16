package work.socialhub.kmisskey.api.request

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class ChannelsOwnedRequest : TokenRequest() {

    var limit: Int? = null
    var sinceId: String? = null
    var untilId: String? = null
}
