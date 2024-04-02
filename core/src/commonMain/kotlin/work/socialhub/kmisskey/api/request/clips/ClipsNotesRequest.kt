package work.socialhub.kmisskey.api.request.clips

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import work.socialhub.kmisskey.api.request.protocol.PagingBuilder
import kotlin.js.JsExport

@JsExport
@Serializable
class ClipsNotesRequest : PagingBuilder, TokenRequest() {

    var clipId: String? = null

    override var limit: Int? = null
    override var sinceId: String? = null
    override var untilId: String? = null
}
