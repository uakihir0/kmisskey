package work.socialhub.kmisskey.entity.contant

enum class WebhooksType(
    val code: String
) {
    MENTION("mention"),
    UNFOLLOW("unfollow"),
    FOLLOW("follow"),
    FOLLOWED("followed"),
    NOTE("note"),
    REPLY("reply"),
    RENOTE("renote"),
    REACTION("reaction");
}
