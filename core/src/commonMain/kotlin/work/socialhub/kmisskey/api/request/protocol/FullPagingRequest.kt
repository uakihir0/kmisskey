package work.socialhub.kmisskey.api.request.protocol

import kotlinx.serialization.Serializable

@Serializable
open class FullPagingRequest : PagingRequest() {
    var sinceDate: Int? = null
    var untilDate: Int? = null
}
