package work.socialhub.kmisskey.api.request.users

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class UsersReactionsRequest : TokenRequest() {

    var userId: String? = null

    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
}
