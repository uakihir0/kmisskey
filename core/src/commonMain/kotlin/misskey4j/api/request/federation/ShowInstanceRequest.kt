package misskey4j.api.request.federation

import kotlinx.serialization.Serializable

@Serializable
class ShowInstanceRequest {
    var host: String? = null
}
