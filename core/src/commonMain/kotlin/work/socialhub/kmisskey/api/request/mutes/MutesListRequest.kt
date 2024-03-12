package work.socialhub.kmisskey.api.request.mutes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class MutesListRequest : TokenRequest() {

    var limit: Int? = null
    var sinceId: String? = null
    var untilId: String? = null
}

