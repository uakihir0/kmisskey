package work.socialhub.kmisskey.api.response.users

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.Follow
import kotlin.js.JsExport

@JsExport
@Serializable
class UsersFollowingsResponse : Follow()
