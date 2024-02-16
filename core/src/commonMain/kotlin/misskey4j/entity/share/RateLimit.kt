package misskey4j.entity.share

import kotlinx.datetime.Instant

class RateLimit {

    var limit: Int = 0
    var remaining: Int = 0
    var reset: Instant? = null

    companion object {
        const val X_RATELIMIT_LIMIT = "X-RateLimit-Limit"
        const val X_RATELIMIT_REMAINING = "X-RateLimit-Remaining"
        const val X_RATELIMIT_RESET = "X-RateLimit-Reset"

        // TODO: Implement this
//        fun of(response: HttpResponse?): RateLimit? {
//            if (response == null) {
//                return null
//            }
//
//            try {
//                val limit: String = response.getResponseHeader(X_RATELIMIT_LIMIT)
//                val remaining: String = response.getResponseHeader(X_RATELIMIT_REMAINING)
//                val reset: String = response.getResponseHeader(X_RATELIMIT_RESET)
//
//                val rateLimit = RateLimit()
//                rateLimit.limit = limit.toInt()
//                rateLimit.remaining = remaining.toInt()
//
//                val dates = reset.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
//                val format: java.text.DateFormat = java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
//                format.setTimeZone(java.util.TimeZone.getTimeZone("UTC"))
//                rateLimit.reset = format.parse(dates[0])
//
//                return rateLimit
//            } catch (e: java.lang.Exception) {
//                return null
//            }
//        }
    }
}
