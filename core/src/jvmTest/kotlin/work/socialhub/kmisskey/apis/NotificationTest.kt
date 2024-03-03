package work.socialhub.kmisskey.apis

import work.socialhub.kmisskey.AbstractTest
import work.socialhub.kmisskey.api.request.i.INotificationsRequest
import kotlin.test.Test

class NotificationTest : AbstractTest() {

    @Test
    fun testNotification() {
        val misskey = misskey()

        misskey.accounts().iNotifications(
            INotificationsRequest()
        )
    }
}
