package work.socialhub.kmisskey.api.request.clips

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class ClipsNotesRequest : TokenRequest() {

    var clipId: String? = null
    var limit: Int? = null
    var sinceId: String? = null
    var untilId: String? = null
}
