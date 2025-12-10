package work.socialhub.kmisskey.api.request.files

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class FilesUpdateRequest : TokenRequest() {
    var fileId: String? = null
    var folderId: String? = null
    var name: String? = null
    var isSensitive: Boolean? = null
    var comment: String? = null
}
