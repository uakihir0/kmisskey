package work.socialhub.kmisskey.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmisskey.AbstractTest
import work.socialhub.kmisskey.api.request.i.INotificationsRequest
import kotlin.test.Test

class NotificationTest : AbstractTest() {

    @Test
    fun testNotification() = runTest {
        val notifications = misskey().accounts()
            .iNotifications(INotificationsRequest())

        for (notification in notifications.data) {
            println(notification.id)
        }
    }
}
