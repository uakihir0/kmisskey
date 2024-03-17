package work.socialhub.kmisskey.api.request.antennas

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class AntennasNotesRequest : TokenRequest() {

    var antennaId: String? = null
    var limit: Int? = null
    var sinceId: String? = null
    var untilId: String? = null
    var sinceDate: Int? = null
    var untilDate: Int? = null
}
