package work.socialhub.kmisskey.api.request.folders

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class FoldersShowRequest : TokenRequest() {
    var folderId: String? = null
}
