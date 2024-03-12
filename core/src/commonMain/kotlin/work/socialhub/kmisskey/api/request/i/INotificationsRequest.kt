package work.socialhub.kmisskey.api.request.i

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class INotificationsRequest : TokenRequest() {

    var limit: Int? = null
    var sinceId: String? = null
    var untilId: String? = null
    var following: Boolean? = null
    var markAsRead: Boolean? = null

    var includeTypes: Array<String>? = null
    var excludeTypes: Array<String>? = null
}