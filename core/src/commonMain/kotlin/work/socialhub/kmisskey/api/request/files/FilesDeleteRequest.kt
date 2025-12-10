package work.socialhub.kmisskey.api.request.files

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class FilesDeleteRequest : TokenRequest() {
    var fileId: String? = null
}
