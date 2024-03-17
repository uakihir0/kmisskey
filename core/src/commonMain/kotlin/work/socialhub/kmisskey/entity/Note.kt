package work.socialhub.kmisskey.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.user.UserLite
import kotlin.js.JsExport

/**
 * 投稿オブジェクト
 */
@JsExport
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

    var mentions: Array<String>? = null
    var visibleUserIds: Array<String>? = null
    var fileIds: Array<String>? = null
    var files: Array<File>? = null
    var tags: Array<String>? = null

    var poll: Poll? = null
    var emojis: Emojis? = null

    var channelId: String? = null
    var channel: Channel? = null

    var localOnly: Boolean = false

    var reactionAcceptance: String? = null
    var reactionEmojis: Emojis? = null

    @Suppress("NON_EXPORTABLE_TYPE")
    var reactions: Map<String, Int> = mapOf()

    var renoteCount: Int = 0
    var repliesCount: Int = 0

    var uri: String? = null
    var url: String? = null

    var reactionAndUserPairCache: Array<String> = arrayOf()
    var clippedCount: Int = 0
    var myReaction: String? = null


    @SerialName("_featuredId_")
    var featuredId: String? = null

    @SerialName("_prId_")
    var prId: String? = null
}