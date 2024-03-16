package work.socialhub.kmisskey.api.response.meta

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class GetOnlineUsersCountResponse {
    var count: Int? = null
}
