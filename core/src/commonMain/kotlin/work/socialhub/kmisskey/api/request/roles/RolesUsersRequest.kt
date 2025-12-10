package work.socialhub.kmisskey.api.request.roles

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class RolesUsersRequest : TokenRequest() {
    var roleId: String? = null
    var sinceId: String? = null
    var untilId: String? = null
    var limit: Int? = null
}
