package misskey4j.api.request.gallery

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class UnlikeGalleryPostRequest(
    var postId: String,
) : TokenRequest()
