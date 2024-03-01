package misskey4j.apis

import kotlinx.coroutines.runBlocking
import misskey4j.AbstractTest
import misskey4j.entity.Note
import misskey4j.entity.Notification
import misskey4j.entity.User
import misskey4j.stream.MisskeyStream
import misskey4j.stream.callback.*
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

    class Callback : MentionCallback, ReplayCallback, RenoteCallback, FollowedCallback, NotificationCallback,
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
