package work.socialhub.kmisskey.apis

import kotlinx.coroutines.runBlocking
import work.socialhub.kmisskey.AbstractTest
import work.socialhub.kmisskey.entity.Note
import work.socialhub.kmisskey.entity.Notification
import work.socialhub.kmisskey.entity.user.User
import work.socialhub.kmisskey.stream.MisskeyStream
import work.socialhub.kmisskey.stream.callback.*
import kotlin.test.Test

class StreamTest : AbstractTest() {

    @Test
    fun testMainStream() {
        runBlocking {
            val stream = MisskeyStream(misskey())

            stream.client.openedCallback {
                runBlocking { stream.main(Callback()) }
            }

            stream.open()
            Thread.sleep(1000 * 1000L)
        }
    }

    @Test
    fun testHomeTimeLineStream() {
        runBlocking {
            val stream = MisskeyStream(misskey())

            stream.client.openedCallback {
                runBlocking { stream.homeTimeLine(Callback()) }
            }

            stream.open()
            Thread.sleep(100 * 1000L)
        }
    }

    @Test
    fun testGlobalTimeLineStream() {
        runBlocking {
            val stream = MisskeyStream(misskey())

            stream.client.openedCallback {
                runBlocking { stream.globalTimeline(Callback()) }
            }

            stream.open()
            Thread.sleep(100 * 1000L)
        }
    }

    class Callback :
        MentionCallback,
        ReplayCallback,
        RenoteCallback,
        FollowedCallback,
        NotificationCallback,
        TimelineCallback {

        override fun onNotification(notification: Notification) {
            println("!!onNotification!!")
        }

        override fun onFollowed(user: User) {
            println("!!onFollowed!!")
        }

        override fun onMention(note: Note) {
            println("!!onMention!!")
        }

        override fun onReply(note: Note) {
            println("!!onReply!!")
        }

        override fun onRenote(note: Note) {
            println("!!onRenote!!")
        }

        override fun onNoteUpdate(note: Note) {
            println("!!onNoteUpdate!!")
        }
    }
}
