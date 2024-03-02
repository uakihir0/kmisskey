package misskey4j.stream.callback

import misskey4j.entity.user.User

interface FollowedCallback : EventCallback {
    fun onFollowed(user: User)
}
