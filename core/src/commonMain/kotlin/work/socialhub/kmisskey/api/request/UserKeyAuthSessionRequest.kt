package work.socialhub.kmisskey.api.request

import kotlinx.serialization.Serializable

@Serializable
class UserKeyAuthSessionRequest {

    var appSecret: String? = null
    var token: String? = null
}
