package misskey4j.api.request.gallery

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class DeleteGalleryPostRequest(
    var postId: String,
) : TokenRequest()
