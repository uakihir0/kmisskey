package work.socialhub.kmisskey.entity.user

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.AvatarDecoration
import work.socialhub.kmisskey.entity.BadgeRole
import work.socialhub.kmisskey.entity.Emojis
import work.socialhub.kmisskey.entity.Instance
import work.socialhub.kmisskey.entity.Role
import work.socialhub.kmisskey.entity.UserPolicies

@Serializable
open class UserLite : User() {

    override lateinit var id: String
    override var name: String? = null
    override lateinit var username: String

    /** The local host is represented with null. */
    override var host: String? = null

    override var avatarUrl: String? = null
    override var avatarBlurhash: String? = null
    override var avatarDecorations: List<AvatarDecoration> = listOf()

    override var isBot: Boolean = false
    override var isCat: Boolean = false

    override var instance: Instance? = null
    override var emojis: Emojis? = null
    override lateinit var onlineStatus: String
    override var badgeRoles: List<BadgeRole> = listOf()
    override var roles: List<Role> = listOf()
    override var policies: UserPolicies? = null
}
