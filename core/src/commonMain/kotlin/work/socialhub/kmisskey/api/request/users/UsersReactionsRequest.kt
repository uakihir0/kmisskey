package work.socialhub.kmisskey.api.request.users

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import work.socialhub.kmisskey.api.request.protocol.PagingBuilder
import kotlin.js.JsExport

@JsExport
@Serializable
class UsersReactionsRequest : PagingBuilder, TokenRequest() {

    var userId: String? = null

    override var limit: Int? = null
    override var sinceId: String? = null
    override var untilId: String? = null
}
