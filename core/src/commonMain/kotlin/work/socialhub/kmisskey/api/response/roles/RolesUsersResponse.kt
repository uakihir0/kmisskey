package work.socialhub.kmisskey.api.response.roles

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.user.User
import kotlin.js.JsExport

@JsExport
@Serializable
class RolesUsersResponse {
    var id: String? = null
    var user: User? = null
}
