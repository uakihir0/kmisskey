package work.socialhub.kmisskey.stream.model

import kotlinx.serialization.Serializable

@Serializable
class StreamRequest<T>(
    var type: String,
    var body: Body<T>
) {
    @Serializable
    class Body<T>(
        var id: String,
        var channel: String,
        var params: T? = null,
    )
}

