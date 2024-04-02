package work.socialhub.kmisskey.api.request.blocks

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import work.socialhub.kmisskey.api.request.protocol.PagingBuilder
import kotlin.js.JsExport

@JsExport
@Serializable
class BlocksListRequest : PagingBuilder, TokenRequest() {

    override var limit: Int? = null
    override var sinceId: String? = null
    override var untilId: String? = null
}
