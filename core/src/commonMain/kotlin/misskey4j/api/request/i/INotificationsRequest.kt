package misskey4j.api.request.i

import misskey4j.api.model.TokenRequest

class INotificationsRequest(
    i: String
) : TokenRequest(i) {

    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
    var following: Boolean? = null
    var markAsRead: Boolean? = null

    var includeTypes: List<String>? = null
    var excludeTypes: List<String>? = null
}