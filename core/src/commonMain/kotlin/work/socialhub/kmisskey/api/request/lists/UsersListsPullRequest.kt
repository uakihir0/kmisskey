package work.socialhub.kmisskey.api.request.lists

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class UsersListsPullRequest : TokenRequest() {

    var listId: String? = null
    var userId: String? = null
}
