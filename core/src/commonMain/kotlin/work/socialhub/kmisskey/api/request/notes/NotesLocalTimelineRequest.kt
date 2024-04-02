package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import work.socialhub.kmisskey.api.request.protocol.FullPagingBuilder
import kotlin.js.JsExport

@JsExport
@Serializable
class NotesLocalTimelineRequest : FullPagingBuilder, TokenRequest() {

    var withFiles: Boolean? = null
    var fileType: Array<String>? = null
    var excludeNsfw: Boolean? = null

    override var limit: Int? = null
    override var sinceId: String? = null
    override var untilId: String? = null
    override var sinceDate: Int? = null
    override var untilDate: Int? = null
}
