package work.socialhub.kmisskey.api.request.files

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class FilesCreateRequest : TokenRequest() {

    var folderId: String? = null
    var name: String? = null
    var comment: String? = null
    var sensitive: Boolean? = null
    var force: Boolean? = null
    var bytes: ByteArray? = null
}

