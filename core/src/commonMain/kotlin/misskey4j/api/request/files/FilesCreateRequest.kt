package misskey4j.api.request.files

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class FilesCreateRequest(
    override var i: String
) : TokenRequest() {

    var folderId: String? = null
    var name: String? = null
    var sensitive: Boolean? = null
    var force: Boolean? = null
    var bytes: ByteArray? = null
}

