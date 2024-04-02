package work.socialhub.kmisskey.api.request.channels

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class ChannelsMyFavoritesRequest : TokenRequest()
