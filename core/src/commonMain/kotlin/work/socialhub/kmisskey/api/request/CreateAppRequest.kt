package work.socialhub.kmisskey.api.request

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class CreateAppRequest {

    var name: String? = null
    var description: String? = null
    var permission: Array<String>? = null
    var callbackUrl: String? = null
}
