package work.socialhub.kmisskey.api.request.protocol

interface PagingBuilder {
    var limit: Int?
    var sinceId: String?
    var untilId: String?
}
