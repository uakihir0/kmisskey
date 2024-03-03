package work.socialhub.kmisskey.stream.callback

import work.socialhub.kmisskey.entity.user.User

interface FollowedCallback : EventCallback {
    fun onFollowed(user: User)
}
