package work.socialhub.kmisskey.api.response

import kotlinx.serialization.Serializable

@Serializable
class CreateAppResponse {

    var id: String? = null
    var name: String? = null
    var callbackUrl: String? = null
    var permission: List<String>? = null
    var secret: String? = null
}

