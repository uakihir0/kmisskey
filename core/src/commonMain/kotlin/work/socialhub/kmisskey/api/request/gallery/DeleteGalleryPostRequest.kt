package work.socialhub.kmisskey.api.request.gallery

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class DeleteGalleryPostRequest(
    var postId: String,
) : TokenRequest()
