package work.socialhub.kmisskey.api.response.messages

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.Message
import kotlin.js.JsExport

@JsExport
@Serializable
class MessagingHistoryResponse : Message()
