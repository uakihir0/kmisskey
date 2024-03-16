package work.socialhub.kmisskey.api.request.gallery

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class CreateGalleryPostRequest(
    var title: String,
    var fileIds: Array<String>,
) : TokenRequest() {

    var description: String? = null
    var isSensitive: Boolean = false
}
