package misskey4j.entity.user

import kotlinx.serialization.Serializable
import misskey4j.entity.AvatarDecoration
import misskey4j.entity.BadgeRole
import misskey4j.entity.Emojis
import misskey4j.entity.Instance

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
}
