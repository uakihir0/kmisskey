package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable

@Serializable
class Error {
    var error: ErrorDetail? = null

    @Serializable
    class ErrorDetail {
        var message: String? = null
        var code: String? = null
        var id: String? = null
    }
}
