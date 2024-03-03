package work.socialhub.kmisskey.stream.callback

import work.socialhub.kmisskey.entity.Notification

interface NotificationCallback : EventCallback {
    fun onNotification(notification: Notification)
}
