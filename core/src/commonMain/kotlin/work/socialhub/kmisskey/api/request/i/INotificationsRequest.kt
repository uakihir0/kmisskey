package work.socialhub.kmisskey.api.request.i

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import work.socialhub.kmisskey.api.request.protocol.PagingBuilder
import kotlin.js.JsExport

@JsExport
@Serializable
class INotificationsRequest : PagingBuilder, TokenRequest() {

    var following: Boolean? = null
    var markAsRead: Boolean? = null

    var includeTypes: Array<String>? = null
    var excludeTypes: Array<String>? = null

    override var limit: Int? = null
    override var sinceId: String? = null
    override var untilId: String? = null
}