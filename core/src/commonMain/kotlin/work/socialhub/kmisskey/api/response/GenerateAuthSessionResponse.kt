package work.socialhub.kmisskey.api.response

import kotlinx.serialization.Serializable

@Serializable
class GenerateAuthSessionResponse {
    var token: String? = null
    var url: String? = null
}
