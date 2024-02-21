package misskey4j.api.request.users

import kotlinx.serialization.Serializable

@Serializable
class UsersSearchRequest {

    var query: String? = null

    var offset: Long? = null
    var limit: Long? = null

    var localOnly: Boolean? = null
    var detail: Boolean? = null
}
