package work.socialhub.kmisskey


class MisskeyException : RuntimeException {

    constructor(e: Exception) : super(e)

    constructor(statusCode: Int, message: String) : super(message) {
        this.statusCode = statusCode
    }

    constructor(message: String?) : super(message)

    var statusCode: Int? = null
}

