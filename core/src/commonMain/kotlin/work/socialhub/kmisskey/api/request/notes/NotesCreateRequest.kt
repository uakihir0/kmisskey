package work.socialhub.kmisskey.api.request.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.PollRequest
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class NotesCreateRequest : TokenRequest() {

    var visibility: String? = null
    var visibleUserIds: Array<String>? = null

    var text: String? = null
    var cw: String? = null

    var viaMobile: Boolean? = null
    var localOnly: Boolean? = null
    var noExtractMentions: Boolean? = null
    var noExtractHashtags: Boolean? = null
    var noExtractEmojis: Boolean? = null

    var fileIds: Array<String>? = null
    var replyId: String? = null
    var renoteId: String? = null

    var channelId: String? = null
    var poll: PollRequest? = null
}
