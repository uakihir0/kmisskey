package misskey4j.stream.model

import kotlinx.serialization.Serializable

@Serializable
class StreamResponse<T : Any> {

    lateinit var type: String
    lateinit var body: T

    @Serializable
    class BodyOnlyType {
        var id: String? = null
        var type: String? = null
    }

    @Serializable
    class BodyWithBody<J : Any> {
        var id: String? = null
        var type: String? = null
        lateinit var body: J
    }
}
