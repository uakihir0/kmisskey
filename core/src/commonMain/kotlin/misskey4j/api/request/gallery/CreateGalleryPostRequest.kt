package misskey4j.api.request.gallery

import kotlinx.serialization.Serializable
import misskey4j.api.model.TokenRequest

@Serializable
class CreateGalleryPostRequest(
    override var i: String,
    var title: String,
    var fileIds: List<String>,
) : TokenRequest() {

    var description: String? = null
    var isSensitive: Boolean = false
}
