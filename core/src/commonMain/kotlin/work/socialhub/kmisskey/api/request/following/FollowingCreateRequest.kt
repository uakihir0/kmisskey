package work.socialhub.kmisskey.api.request.following

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class FollowingCreateRequest : TokenRequest() {

    var userId: String? = null
}
