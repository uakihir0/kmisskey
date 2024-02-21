package misskey4j.entity.share

/**
 * response wrapper for misskey api.
 */
class Response<T>(
    var data: T,
    var json: String,
    var limit: RateLimit? = null,
)
