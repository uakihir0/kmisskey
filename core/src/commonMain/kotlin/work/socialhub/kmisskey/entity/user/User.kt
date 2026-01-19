package work.socialhub.kmisskey.entity.user

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.AvatarDecoration
import work.socialhub.kmisskey.entity.BadgeRole
import work.socialhub.kmisskey.entity.Color
import work.socialhub.kmisskey.entity.Emojis
import work.socialhub.kmisskey.entity.Instance
import work.socialhub.kmisskey.entity.Role
import work.socialhub.kmisskey.entity.UserPolicies
import work.socialhub.kmisskey.util.BlurHashDecoder
import work.socialhub.kmisskey.util.ColorDecoder
import work.socialhub.kmisskey.util.json.UserSerializer
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
    abstract var onlineStatus: String?

    abstract var badgeRoles: Array<BadgeRole>
    abstract var roles: Array<Role>
    abstract var policies: UserPolicies?

    /*
     * The following are original items.
     * 以下、独自項目
     */

    // サーバーから返される色文字列 (例: "rgb(169,122,93)", "#86b300")
    var avatarColor: String? = null

    // avatarColor を Color オブジェクトとして取得
    // avatarColor が null の場合は avatarBlurhash から計算
    val avatarColorObject: Color?
        get() {
            // avatarColor が設定されている場合はそれをデコード
            avatarColor?.let {
                return ColorDecoder.decode(it)
            }

            // avatarBlurhash からフォールバック計算
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
}