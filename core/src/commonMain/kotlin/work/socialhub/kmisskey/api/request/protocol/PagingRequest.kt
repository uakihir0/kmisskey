package work.socialhub.kmisskey.api.request.protocol

import kotlinx.serialization.Serializable

@Serializable
open class PagingRequest {

    var limit: Int? = null
    var sinceId: String? = null
    var untilId: String? = null
}
