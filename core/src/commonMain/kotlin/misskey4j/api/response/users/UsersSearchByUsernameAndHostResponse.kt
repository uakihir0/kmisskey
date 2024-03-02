package misskey4j.api.response.users

import kotlinx.serialization.Serializable
import misskey4j.entity.user.User
import misskey4j.entity.user.UserLite

@Serializable
class UsersSearchByUsernameAndHostResponse : User()
