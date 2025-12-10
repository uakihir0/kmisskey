package work.socialhub.kmisskey.api.request.files

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class FilesShowRequest : TokenRequest() {
    var fileId: String? = null
    var url: String? = null
}
