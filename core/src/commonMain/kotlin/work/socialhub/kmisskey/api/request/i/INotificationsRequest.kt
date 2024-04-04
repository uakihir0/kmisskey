package work.socialhub.kmisskey.api.request.i

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import work.socialhub.kmisskey.api.request.protocol.PagingRequest
import work.socialhub.kmisskey.api.request.protocol.PagingTokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class INotificationsRequest : PagingTokenRequest() {

    var following: Boolean? = null
    var markAsRead: Boolean? = null

    var includeTypes: Array<String>? = null
    var excludeTypes: Array<String>? = null
}