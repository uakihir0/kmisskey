package misskey4j.api.request.protocol

interface PagingBuilder<T> {
    fun limit(limit: Long?): T
    fun sinceId(sinceId: String?): T
    fun untilId(untilId: String?): T
}
