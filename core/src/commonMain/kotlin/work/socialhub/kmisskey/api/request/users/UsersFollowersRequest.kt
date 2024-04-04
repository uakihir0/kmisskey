package work.socialhub.kmisskey.api.request.users

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.request.protocol.PagingRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class UsersFollowersRequest: PagingRequest() {

    var userId: String? = null
    var username: String? = null
    var host: String? = null
}
