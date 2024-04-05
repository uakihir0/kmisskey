package work.socialhub.kmisskey.api.request.channels

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.request.protocol.FullPagingTokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class ChannelsTimelineRequest : FullPagingTokenRequest() {

    var channelId: String? = null
}