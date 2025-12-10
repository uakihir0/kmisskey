package work.socialhub.kmisskey.api.request.files

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class FilesFindRequest : TokenRequest() {
    var name: String? = null
    var folderId: String? = null
}
