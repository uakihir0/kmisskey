package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import work.socialhub.kmisskey.api.request.protocol.PagingBuilder
import kotlin.js.JsExport

@JsExport
@Serializable
class NotesSearchByTagRequest(
    val tag: String
) : PagingBuilder, TokenRequest() {

    // TODO support query
    // The outer arrays are chained with OR, the inner arrays are chained with AND.
    // var query: Array<Array<String>>? = null

    var reply: Boolean? = null
    var renote: Boolean? = null
    var withFiles: Boolean? = null
    var poll: Boolean? = null

    override var limit: Int? = null
    override var sinceId: String? = null
    override var untilId: String? = null
}
