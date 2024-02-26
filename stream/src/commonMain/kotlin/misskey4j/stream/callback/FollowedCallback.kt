package misskey4j.stream.callback

import misskey4j.entity.User

interface FollowedCallback : EventCallback {
    fun onFollowed(user: User?)
}
