package misskey4j.entity.user

import kotlinx.serialization.Serializable
import misskey4j.entity.*
import misskey4j.util.BlurHashDecoder
import misskey4j.util.json.UserSerializer

/**
 * @see UserLite
 * @see UserDetailedNotMe
 * @see MeDetailed
 */
@Serializable(with = UserSerializer::class)
abstract class User {

    val asUserLite get() = this as? UserLite
    val asUserDetailedNotMe get() = this as? UserDetailedNotMe
    val asMeDetailed get() = this as? MeDetailed

    /*
     * 以下 UserLite の内容
     * The following are the contents of UserLite.
     */

    open lateinit var id: String
    open var name: String? = null
    // open lateinit var username: String

    /** The local host is represented with null. */
    open var host: String? = null

    open var avatarUrl: String? = null
    open var avatarBlurhash: String? = null
    open var avatarDecorations: List<AvatarDecoration> = listOf()

    open var isBot: Boolean = false
    open var isCat: Boolean = false

    open var instance: Instance? = null
    open var emojis: Emojis? = null
    open lateinit var onlineStatus: String
    open var badgeRoles: List<BadgeRole> = listOf()

    /*
     * The following are original items.
     * 以下、独自項目
     */
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
}