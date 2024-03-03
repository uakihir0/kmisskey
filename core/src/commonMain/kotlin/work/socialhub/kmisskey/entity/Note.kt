package work.socialhub.kmisskey.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.user.UserLite

/**
 * 投稿オブジェクト
 */
@Serializable
open class Note {
    lateinit var id: String

    lateinit var createdAt: String
    var deletedAt: String? = null

    var text: String? = null
    var cw: String? = null

    lateinit var userId: String
    lateinit var user: UserLite

    var replyId: String? = null
    var renoteId: String? = null

    var reply: Note? = null
    var renote: Note? = null

    var isHidden = false
    lateinit var visibility: String

    var mentions: List<String>? = null
    var visibleUserIds: List<String>? = null
    var fileIds: List<String>? = null
    var files: List<File>? = null
    var tags: List<String>? = null

    var poll: Poll? = null
    var emojis: Emojis? = null

    var channelId: String? = null
    var channel: Channel? = null

    var localOnly: Boolean = false

    var reactionAcceptance: String? = null
    var reactionEmojis: Emojis? = null
    var reactions: Map<String, Long> = mapOf()

    var renoteCount: Long = 0
    var repliesCount: Long = 0

    var uri: String? = null
    var url: String? = null

    var reactionAndUserPairCache: List<String> = listOf()
    var clippedCount: Long = 0
    var myReaction: String? = null


    @SerialName("_featuredId_")
    var featuredId: String? = null

    @SerialName("_prId_")
    var prId: String? = null
}