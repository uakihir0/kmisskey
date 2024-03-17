package work.socialhub.kmisskey.api.request.clips

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class ClipsCreateRequest : TokenRequest() {

    var name: String? = null
    var public: Boolean? = null
    var description: String? = null
}
