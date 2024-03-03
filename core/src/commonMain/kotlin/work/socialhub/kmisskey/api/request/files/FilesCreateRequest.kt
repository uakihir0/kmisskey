package work.socialhub.kmisskey.api.request.files

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class FilesCreateRequest : TokenRequest() {

    var folderId: String? = null
    var name: String? = null
    var sensitive: Boolean? = null
    var force: Boolean? = null
    var bytes: ByteArray? = null
}

