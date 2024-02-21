package misskey4j.api.request

import kotlinx.serialization.Serializable

@Serializable
class CreateAppRequest {

    var name: String? = null
    var description: String? = null
    var permission: List<String>? = null
    var callbackUrl: String? = null
}
