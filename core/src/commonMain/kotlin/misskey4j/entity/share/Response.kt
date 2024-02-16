package misskey4j.entity.share

/**
 * response wrapper for misskey api.
 */
class Response<T> {
    var data: T? = null
    var json: String? = null
    var limit: RateLimit? = null
}
