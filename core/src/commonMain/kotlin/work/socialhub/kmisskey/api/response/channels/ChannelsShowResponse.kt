package work.socialhub.kmisskey.api.response.channels

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.Channel
import kotlin.js.JsExport

@JsExport
@Serializable
class ChannelsShowResponse : Channel()
