package work.socialhub.kmisskey.api.response.i

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.Notification
import kotlin.js.JsExport

@JsExport
@Serializable
class INotificationsResponse : Notification()
