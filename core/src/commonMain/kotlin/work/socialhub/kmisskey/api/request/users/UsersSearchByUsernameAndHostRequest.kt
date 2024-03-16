package work.socialhub.kmisskey.api.request.users

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class UsersSearchByUsernameAndHostRequest(
    var username: String
) {
    var limit: Int? = null
    var detail: Boolean? = null
    var host: String? = null
}
