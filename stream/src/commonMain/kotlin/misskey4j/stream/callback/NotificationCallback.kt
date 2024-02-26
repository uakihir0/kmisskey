package misskey4j.stream.callback

import misskey4j.entity.Notification

interface NotificationCallback : EventCallback {
    fun onNotification(notification: Notification)
}
