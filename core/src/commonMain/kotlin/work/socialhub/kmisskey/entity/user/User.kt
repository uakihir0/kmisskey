package work.socialhub.kmisskey.entity.user

import kotlinx.serialization.Serializable
import misskey4j.util.json.UserSerializer
import work.socialhub.kmisskey.entity.*
import work.socialhub.kmisskey.util.BlurHashDecoder
import kotlin.js.JsExport

/**
 * @see UserLite
 * @see UserDetailedNotMe
 * @see MeDetailed
 */
@JsExport
@Serializable(with = UserSerializer::class)
abstract class User {

    val asUserLite get() = this as? UserLite
    val asUserDetailedNotMe get() = this as? UserDetailedNotMe
    val asMeDetailed get() = this as? MeDetailed

    /*
     * 以下 UserLite の内容
     * The following are the contents of UserLite.
     */

    abstract var id: String
    abstract var name: String?
    abstract var username: String

    /** The local host is represented with null. */
    abstract var host: String?

    abstract var avatarUrl: String?
    abstract var avatarBlurhash: String?
    abstract var avatarDecorations: Array<AvatarDecoration>

    abstract var isBot: Boolean
    abstract var isCat: Boolean

    abstract var instance: Instance?
    abstract var emojis: Emojis?
    abstract var onlineStatus: String
    abstract var badgeRoles: Array<BadgeRole>

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