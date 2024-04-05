package work.socialhub.kmisskey.api.request.i

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.request.protocol.PagingTokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class IListGalleryPostsRequest : PagingTokenRequest()