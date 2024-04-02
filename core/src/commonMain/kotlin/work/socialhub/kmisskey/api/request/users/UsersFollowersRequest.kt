package work.socialhub.kmisskey.api.request.users

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.request.protocol.PagingBuilder
import kotlin.js.JsExport

@JsExport
@Serializable
class UsersFollowersRequest: PagingBuilder {

    var userId: String? = null
    var username: String? = null
    var host: String? = null

    override var limit: Int? = null
    override var sinceId: String? = null
    override var untilId: String? = null
}
