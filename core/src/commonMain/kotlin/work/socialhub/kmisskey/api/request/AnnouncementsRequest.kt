package work.socialhub.kmisskey.api.request

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class AnnouncementsRequest : TokenRequest() {

    var limit: Long? = null
    var withUnreads: Boolean? = null
    var sinceId: String? = null
    var untilId: String? = null
}
