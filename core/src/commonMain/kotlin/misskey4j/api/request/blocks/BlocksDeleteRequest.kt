package misskey4j.api.request.blocks

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class BlocksDeleteRequest(
    override var i: String
) : TokenRequest() {

    var userId: String? = null
}
