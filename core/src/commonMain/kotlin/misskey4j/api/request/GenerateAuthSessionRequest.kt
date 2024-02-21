package misskey4j.api.request

import kotlinx.serialization.Serializable

@Serializable
class GenerateAuthSessionRequest {

    var appSecret: String? = null
}


