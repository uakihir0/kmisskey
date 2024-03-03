package work.socialhub.kmisskey.api.request.gallery

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class CreateGalleryPostRequest(
    var title: String,
    var fileIds: List<String>,
) : TokenRequest() {

    var description: String? = null
    var isSensitive: Boolean = false
}
