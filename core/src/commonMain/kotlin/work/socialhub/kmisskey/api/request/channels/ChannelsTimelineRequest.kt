package work.socialhub.kmisskey.api.request.channels

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import work.socialhub.kmisskey.api.request.protocol.FullPagingBuilder
import kotlin.js.JsExport

@JsExport
@Serializable
class ChannelsTimelineRequest : FullPagingBuilder, TokenRequest() {

    var channelId: String? = null

    override var limit: Int? = null
    override var sinceId: String? = null
    override var untilId: String? = null
    override var sinceDate: Int? = null
    override var untilDate: Int? = null
}