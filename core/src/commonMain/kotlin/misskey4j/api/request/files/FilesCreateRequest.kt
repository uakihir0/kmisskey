package misskey4j.api.request.files

import misskey4j.api.model.TokenRequest

class FilesCreateRequest(
    i: String
) : TokenRequest(i) {

    var folderId: String? = null
    var name: String? = null
    var sensitive: Boolean? = null
    var force: Boolean? = null
    var bytes: ByteArray? = null
}

