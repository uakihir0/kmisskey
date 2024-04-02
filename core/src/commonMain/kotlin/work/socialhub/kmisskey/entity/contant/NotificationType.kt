package work.socialhub.kmisskey.entity.contant

enum class NotificationType(
    val code: String
) {
    FOLLOW("follow"),
    MENTION("mention"),
    REPLY("reply"),
    RENOTE("renote"),
    QUOTE("quote"),
    REACTION("reaction"),
    POLL_VOTE("pollVote"),
    RECEIVE_FOLLOW_REQUEST("receiveFollowRequest");
}
