package work.socialhub.kmisskey.api.request.users

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class UsersReportAbuseRequest : TokenRequest() {

    var userId: String? = null
    var comment: String? = null
}
