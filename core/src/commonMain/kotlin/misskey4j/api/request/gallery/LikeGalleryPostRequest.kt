package misskey4j.api.request.gallery

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class LikeGalleryPostRequest(
    var postId: String,
) : TokenRequest()