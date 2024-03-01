package misskey4j.apis

import misskey4j.AbstractTest
import misskey4j.api.request.i.INotificationsRequest
import kotlin.test.Test

class NotificationTest : AbstractTest() {

    @Test
    fun testNotification() {
        val misskey = misskey()

        misskey.accounts().iNotifications(
            INotificationsRequest(misskey.i!!)
        )
    }
}
