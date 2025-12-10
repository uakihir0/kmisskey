package work.socialhub.kmisskey.api.request.roles

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class RolesRequest : TokenRequest() {
}
