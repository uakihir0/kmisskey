package work.socialhub.kmisskey.api.request.gallery

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.request.protocol.PagingTokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class ListGalleryPostsRequest : PagingTokenRequest()
