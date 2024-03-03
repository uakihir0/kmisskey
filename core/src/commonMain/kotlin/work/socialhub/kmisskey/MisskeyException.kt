package work.socialhub.kmisskey


class MisskeyException : RuntimeException {

    constructor(e: Exception) : super(e)

    constructor(statusCode: Int, error: Error) {
        this.statusCode = statusCode
        this.error = error
    }

    var statusCode: Int? = null
    var error: Error? = null
}

