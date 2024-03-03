package work.socialhub.kmisskey.api.request

import kotlinx.serialization.Serializable

@Serializable
class GenerateAuthSessionRequest {

    var appSecret: String? = null
}


