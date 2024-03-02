package misskey4j.entity.user

import kotlinx.serialization.Serializable

/**
 * Misskey には存在しない型
 * User をそのままマッピングすると無限ループになるために作成
 */
@Serializable
open class UserBasic : User() {
    override lateinit var id: String
}