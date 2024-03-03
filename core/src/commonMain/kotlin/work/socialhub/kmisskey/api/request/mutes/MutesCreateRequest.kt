package work.socialhub.kmisskey.api.request.mutes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class MutesCreateRequest : TokenRequest() {

    var userId: String? = null
}
