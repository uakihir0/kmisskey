package work.socialhub.kmisskey.api.request.i

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class INotificationsRequest : TokenRequest() {

    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
    var following: Boolean? = null
    var markAsRead: Boolean? = null

    var includeTypes: List<String>? = null
    var excludeTypes: List<String>? = null
}