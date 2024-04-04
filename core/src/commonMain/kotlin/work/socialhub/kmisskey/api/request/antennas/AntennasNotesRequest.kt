package work.socialhub.kmisskey.api.request.antennas

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import work.socialhub.kmisskey.api.request.protocol.FullPagingRequest
import work.socialhub.kmisskey.api.request.protocol.FullPagingTokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class AntennasNotesRequest : FullPagingTokenRequest() {

    var antennaId: String? = null
}
