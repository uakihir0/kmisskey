package misskey4j.stream.model

import kotlinx.serialization.Serializable

@Serializable
class StreamResponse<T> {

    var type: String? = null
    var body: T? = null

    @Serializable
    class BodyOnlyType {
        var id: String? = null
        var type: String? = null
    }

    @Serializable
    class BodyWithBody<J> {
        var id: String? = null
        var type: String? = null
        var body: J? = null
    }
}
