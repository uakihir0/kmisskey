package misskey4j

import misskey4j.entity.Error

class MisskeyException : RuntimeException {

    constructor(e: Exception) : super(e)

    constructor(statusCode: Int, error: Error) {
        this.statusCode = statusCode
        this.error = error
    }

    var statusCode: Int? = null
    var error: Error? = null
}

