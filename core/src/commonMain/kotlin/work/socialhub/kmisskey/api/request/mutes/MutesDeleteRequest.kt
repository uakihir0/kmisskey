package work.socialhub.kmisskey.api.request.mutes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class MutesDeleteRequest : TokenRequest() {

    var userId: String? = null
}
