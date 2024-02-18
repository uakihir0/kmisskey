package misskey4j.entity

import kotlinx.serialization.Serializable
import misskey4j.util.BlurHashDecoder

/**
 * ユーザーオブジェクト
 */
@Serializable
open class User {
    lateinit var id: String
    lateinit var username: String

    var name: String? = null
    var url: String? = null

    lateinit var avatarUrl: String
    lateinit var avatarBlurhash: String

    var avatarColor: Color? = null
        get() {
            if (field == null) {
                val decoder = BlurHashDecoder.instance
                val ary = decoder.decode(
                    avatarBlurhash,
                    1,
                    1,
                    1F,
                    false
                ) ?: return null

                val color = Color()
                color.r = ary[0][0][0]
                color.g = ary[0][0][1]
                color.b = ary[0][0][2]
                return color
            }
            return field
        }

    var bannerUrl: String? = null
    lateinit var bannerColor: Color

    var host: String? = null
    var description: String? = null

    var birthday: String? = null
    var createdAt: String? = null
    var updatedAt: String? = null
    var location: String? = null

    var followersCount: Long? = null
    var followingCount: Long? = null
    var notesCount: Long? = null

    var pinnedNoteIds: List<String>? = null
    var pinnedNotes: List<Note>? = null

    var bot: Boolean = false
    var cat: Boolean = false
    var admin: Boolean = false
    var moderator: Boolean = false

    var locked: Boolean = false
    var hasUnreadSpecifiedNotes = false
    var hasUnreadMentions = false
    var onlineStatus: String? = null

    var instance: Instance? = null
    var emojis: Emojis? = null
    var fields: List<Field>? = null
}
