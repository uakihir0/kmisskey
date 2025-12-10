package work.socialhub.kmisskey.api.request.folders

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class FoldersCreateRequest : TokenRequest() {
    var name: String? = null
    var parentId: String? = null
}
