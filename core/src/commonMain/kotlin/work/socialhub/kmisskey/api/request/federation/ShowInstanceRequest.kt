package work.socialhub.kmisskey.api.request.federation

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class ShowInstanceRequest {
    var host: String? = null
}
