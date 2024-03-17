package work.socialhub.kmisskey.api.request.users

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class UsersReactionsRequest : TokenRequest() {

    var userId: String? = null
    var limit: Int? = null
    var sinceId: String? = null
    var untilId: String? = null
}
