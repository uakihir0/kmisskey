package work.socialhub.kmisskey.api.request.i

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest

@Serializable
class IListGalleryPostsRequest : TokenRequest() {

    var limit: Long? = null
    var sinceId: String? = null
    var untilId: String? = null
}
