package work.socialhub.kmisskey.entity.share

/**
 * response wrapper for misskey api.
 */
class Response<T>(
    var data: T,
    var json: String,
    var limit: RateLimit? = null,
)
