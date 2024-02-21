package misskey4j.api.request.gallery

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class ShowGalleryPostRequest(
    override var i: String,
) : TokenRequest() {

    var postId: String? = null
}