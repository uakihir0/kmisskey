package work.socialhub.kmisskey.api.request.files

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class FilesRequest : TokenRequest() {
    var limit: Int? = null
    var sinceId: String? = null
    var untilId: String? = null
    var folderId: String? = null
    var type: String? = null
    var sort: String? = null
}
