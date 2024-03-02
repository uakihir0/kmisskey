package misskey4j.api.request.blocks

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class BlocksCreateRequest : TokenRequest() {

    var userId: String? = null
}
