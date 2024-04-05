package work.socialhub.kmisskey.api.request.users

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.request.protocol.PagingTokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class ListUserGalleryPostsRequest(
    var userId: String,
) : PagingTokenRequest()