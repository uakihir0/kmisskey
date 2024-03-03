package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable

@Serializable
open class Relation {

    var id: String? = null
    var hasPendingFollowRequestFromYou = false
    var hasPendingFollowRequestToYou = false

    var isFollowing = false
    var isFollowed = false
    var isBlocking = false
    var isBlocked = false
    var isMuted = false

    override fun toString(): String {
        return "Relation{" +
                "id='$id'" +
                ", hasPendingFollowRequestFromYou=$hasPendingFollowRequestFromYou" +
                ", hasPendingFollowRequestToYou=$hasPendingFollowRequestToYou" +
                ", isFollowing=$isFollowing" +
                ", isFollowed=$isFollowed" +
                ", isBlocking=$isBlocking" +
                ", isBlocked=$isBlocked" +
                ", isMuted=$isMuted" +
                '}'
    }
}