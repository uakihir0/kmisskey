package misskey4j.api.request

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class ApShowRequest : TokenRequest() {

    var uri: String? = null
}
