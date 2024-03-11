package work.socialhub.kmisskey.entity.share

import kotlin.js.JsExport

/**
 * response wrapper for misskey api.
 */
@JsExport
class Response<T>(
    var data: T,
    var json: String,
    var limit: RateLimit? = null,
)
