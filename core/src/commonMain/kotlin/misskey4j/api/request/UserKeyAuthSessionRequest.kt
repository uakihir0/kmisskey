package misskey4j.api.request

import kotlinx.serialization.Serializable

@Serializable
class UserKeyAuthSessionRequest {

    var appSecret: String? = null
    var token: String? = null
}
