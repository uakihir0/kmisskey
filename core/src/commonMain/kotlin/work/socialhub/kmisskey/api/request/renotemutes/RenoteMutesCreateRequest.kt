package work.socialhub.kmisskey.api.request.renotemutes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class RenoteMutesCreateRequest : TokenRequest() {

    var userId: String? = null
}
