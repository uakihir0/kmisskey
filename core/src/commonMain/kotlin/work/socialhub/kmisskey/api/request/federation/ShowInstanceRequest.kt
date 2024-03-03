package work.socialhub.kmisskey.api.request.federation

import kotlinx.serialization.Serializable

@Serializable
class ShowInstanceRequest {
    var host: String? = null
}
