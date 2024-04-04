package work.socialhub.kmisskey.api.request.protocol

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
open class PagingTokenRequest : TokenRequest() {
    var limit: Int? = null
    var sinceId: String? = null
    var untilId: String? = null
}