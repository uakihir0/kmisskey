package misskey4j.api.request.mutes

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class MutesCreateRequest(
    override var i: String
) : TokenRequest() {

    var userId: String? = null
}
