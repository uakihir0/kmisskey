package work.socialhub.kmisskey.api.request.following

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.request.protocol.PagingTokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class FollowingRequestsListRequest : PagingTokenRequest()