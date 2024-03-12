package work.socialhub.kmisskey.api.request.clips

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class ClipsShowRequest(
    val clipId: String
) : TokenRequest()
