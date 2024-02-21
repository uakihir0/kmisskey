package misskey4j.api.request.gallery

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class UpdateGalleryPostRequest(
    override var i: String,
    var postId: String,
    var title: String,
    var fileIds: List<String>,
) : TokenRequest() {

    var description: String? = null
    var isSensitive = false
}
