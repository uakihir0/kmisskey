package work.socialhub.kmisskey.api.request.folders

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class FoldersUpdateRequest : TokenRequest() {
    var folderId: String? = null
    var name: String? = null
    var parentId: String? = null
}
