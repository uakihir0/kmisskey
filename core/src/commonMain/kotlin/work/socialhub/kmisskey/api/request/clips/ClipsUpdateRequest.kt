package work.socialhub.kmisskey.api.request.clips

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class ClipsUpdateRequest : TokenRequest() {

    var clipId: String? = null
    var name: String? = null
    var public: Boolean? = null
    var description: String? = null
}
