package misskey4j.api.request.notes

import kotlinx.serialization.Serializable
import misskey4j.api.model.PollRequest
import misskey4j.api.model.TokenRequest

@Serializable
class NotesCreateRequest : TokenRequest() {

    var visibility: String? = null
    var visibleUserIds: List<String>? = null

    var text: String? = null
    var cw: String? = null

    var viaMobile: Boolean? = null
    var localOnly: Boolean? = null
    var noExtractMentions: Boolean? = null
    var noExtractHashtags: Boolean? = null
    var noExtractEmojis: Boolean? = null

    var fileIds: List<String>? = null
    var replyId: String? = null
    var renoteId: String? = null

    var channelId: String? = null
    var poll: PollRequest? = null
}
