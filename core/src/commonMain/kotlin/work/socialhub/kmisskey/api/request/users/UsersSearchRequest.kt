package work.socialhub.kmisskey.api.request.users

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class UsersSearchRequest {

    var query: String? = null
    var offset: Int? = null
    var limit: Int? = null

    var localOnly: Boolean? = null
    var detail: Boolean? = null
}
