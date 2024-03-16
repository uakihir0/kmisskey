package work.socialhub.kmisskey.api.request.meta

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class MetaRequest {
    var detail: Boolean? = null
}
