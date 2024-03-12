package work.socialhub.kmisskey.api.response

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class CreateAppResponse {

    var id: String? = null
    var name: String? = null
    var callbackUrl: String? = null
    var permission: Array<String>? = null
    var secret: String? = null
}

