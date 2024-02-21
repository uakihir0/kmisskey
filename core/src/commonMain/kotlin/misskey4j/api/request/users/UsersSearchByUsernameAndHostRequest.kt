package misskey4j.api.request.users

import kotlinx.serialization.Serializable

@Serializable
class UsersSearchByUsernameAndHostRequest(
    var username: String
) {
    var limit: Long? = null
    var detail: Boolean? = null
    var host: String? = null
}
