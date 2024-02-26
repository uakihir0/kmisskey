package misskey4j.stream.model

class StreamRequest<T> {
    var type: String? = null
    var body: Body<T> = Body()

    class Body<T> {
        var id: String? = null
        var channel: String? = null
        var params: T? = null
    }
}

