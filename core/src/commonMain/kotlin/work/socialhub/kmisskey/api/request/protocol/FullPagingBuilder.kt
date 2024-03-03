package misskey4j.api.request.protocol

interface FullPagingBuilder<T> : PagingBuilder<T> {
    fun sinceDate(sinceDate: Long?): T
    fun untilDate(untilDate: Long?): T
}
