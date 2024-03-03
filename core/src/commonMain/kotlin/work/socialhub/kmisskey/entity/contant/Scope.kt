package work.socialhub.kmisskey.entity.contant

/**
 * 認可スコープを表現するクラス
 */
class Scope(
    val operation: String,
    val target: String
) {
    override fun toString(): String {
        return "$operation:$target"
    }

    /**
     * 認可オペレーションを表現するクラス
     */
    class ScopeOperation(
        val operation: String
    ) {
        fun account() = Scope(operation, "account")
        fun blocks() = Scope(operation, "blocks")
        fun drive() = Scope(operation, "drive")
        fun favorites() = Scope(operation, "favorites")
        fun following() = Scope(operation, "following")
        fun messaging() = Scope(operation, "messaging")
        fun mutes() = Scope(operation, "mutes")
        fun notes() = Scope(operation, "notes")
        fun notifications() = Scope(operation, "notifications")
        fun reactions() = Scope(operation, "reactions")
        fun votes() = Scope(operation, "votes")
        fun pages() = Scope(operation, "pages")
        fun pageLikes() = Scope(operation, "page-likes")
        fun userGroups() = Scope(operation, "user-groups")
        fun channels() = Scope(operation, "channels")
    }

    companion object {
        // すべてのスコープリスト
        val ALL: Array<Scope> = arrayOf(

            // Read Write
            read().account(),
            write().account(),
            read().blocks(),
            write().blocks(),
            read().drive(),
            write().drive(),
            read().favorites(),
            write().favorites(),
            read().following(),
            write().following(),
            read().messaging(),
            write().messaging(),
            read().mutes(),
            write().mutes(),
            read().notifications(),
            write().notifications(),
            read().reactions(),
            write().reactions(),
            read().pages(),
            write().pages(),
            read().pageLikes(),
            write().pageLikes(),
            read().userGroups(),
            write().userGroups(),

            // Channels
            read().channels(),
            write().channels(),

            // Write Only
            write().notes(),
            write().votes()
        )

        fun read(): ScopeOperation {
            return ScopeOperation("read")
        }

        fun write(): ScopeOperation {
            return ScopeOperation("write")
        }
    }
}
