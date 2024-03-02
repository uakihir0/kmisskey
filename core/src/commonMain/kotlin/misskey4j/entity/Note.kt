package misskey4j.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import misskey4j.entity.user.User
import misskey4j.entity.user.UserLite

/**
 * 投稿オブジェクト
 */
@Serializable
open class Note {
    lateinit var id: String
    lateinit var createdAt: String

    var text: String? = null
    var cw: String? = null

    lateinit var userId: String
    lateinit var user: User

    var replyId: String? = null
    var reply: Note? = null
    var renoteId: String? = null
    var renote: Note? = null

    var renoteCount: Long? = null
    var repliesCount: Long? = null

    var viaMobile = false
    var hidden = false

    var visibility: String? = null
    var visibleUserIds: List<String>? = null
    var localOnly: Boolean? = null

    var mentions: List<String>? = null
    var tags: List<String>? = null
    var fileIds: List<String>? = null
    var files: List<File>? = null
    var poll: Poll? = null

    var emojis: Emojis? = null
    var reactions: Map<String, Long>? = null
    var reactionEmojis: Emojis? = null
    var myReaction: String? = null

    var url: String? = null
    var uri: String? = null

    @SerialName("_featuredId_")
    var featuredId: String? = null

    @SerialName("_prId_")
    var prId: String? = null

    var channelId: String? = null
    var channel: Channel? = null
}