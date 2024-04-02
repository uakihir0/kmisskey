package work.socialhub.kmisskey.api.request.antennas

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import work.socialhub.kmisskey.api.request.protocol.FullPagingBuilder
import work.socialhub.kmisskey.api.request.protocol.PagingBuilder
import kotlin.js.JsExport

@JsExport
@Serializable
class AntennasNotesRequest : FullPagingBuilder, TokenRequest() {

    var antennaId: String? = null

    override var limit: Int? = null
    override var sinceId: String? = null
    override var untilId: String? = null
    override var sinceDate: Int? = null
    override var untilDate: Int? = null
}
