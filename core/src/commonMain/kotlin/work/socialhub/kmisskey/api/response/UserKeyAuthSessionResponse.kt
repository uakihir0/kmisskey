package work.socialhub.kmisskey.api.response

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.user.User
import kotlin.js.JsExport

@JsExport
@Serializable
class UserKeyAuthSessionResponse {
    var accessToken: String? = null
    var user: User? = null
}
