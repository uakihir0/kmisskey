package misskey4j.api.request.i

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class IRequest(
    override var i: String
) : TokenRequest()
