package work.socialhub.kmisskey.api.request.notifications

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class NotificationsMarkAllAsReadRequest : TokenRequest()
