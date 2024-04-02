package work.socialhub.kmisskey.api.request.protocol

interface FullPagingBuilder : PagingBuilder {
    var sinceDate: Int?
    var untilDate: Int?
}
