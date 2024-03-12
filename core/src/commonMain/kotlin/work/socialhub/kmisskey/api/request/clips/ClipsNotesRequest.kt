package work.socialhub.kmisskey.api.request.clips

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class ClipsNotesRequest : TokenRequest() {

    var clipId: String? = null
    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
}
