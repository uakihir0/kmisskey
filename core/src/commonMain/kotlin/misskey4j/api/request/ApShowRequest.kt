package misskey4j.api.request

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class ApShowRequest(
    override var i: String
) : TokenRequest() {

    var uri: String? = null
}
