package work.socialhub.kmisskey.api.request.channels

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.request.protocol.PagingTokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class ChannelsOwnedRequest : PagingTokenRequest()