package work.socialhub.kmisskey.apis

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import work.socialhub.kmisskey.AbstractTest
import work.socialhub.kmisskey.entity.Note
import work.socialhub.kmisskey.entity.Notification
import work.socialhub.kmisskey.entity.user.User
import work.socialhub.kmisskey.stream.MisskeyStream
import work.socialhub.kmisskey.stream.callback.FollowedCallback
import work.socialhub.kmisskey.stream.callback.MentionCallback
import work.socialhub.kmisskey.stream.callback.NotificationCallback
import work.socialhub.kmisskey.stream.callback.RenoteCallback
import work.socialhub.kmisskey.stream.callback.ReplayCallback
import work.socialhub.kmisskey.stream.callback.TimelineCallback
import kotlin.test.Test

class StreamTest : AbstractTest() {

    @Test
    fun testMainStream() {
        runBlocking {
            val stream = MisskeyStream(misskey())

            stream.client.openedCallback {
                println("opened.")
            }

            launch { stream.open() }

            delay(10 * 1000L)
            stream.main(Callback())
            delay(1000 * 1000L)
        }
    }

    @Test
    fun testHomeTimeLineStream() {
        runBlocking {
            val stream = MisskeyStream(misskey())

            stream.client.openedCallback {
                println("opened.")
            }

            launch { stream.open() }
            delay(10 * 1000L)
            launch { stream.homeTimeLine(Callback()) }
            delay(1000 * 1000L)
        }
    }

    @Test
    fun testGlobalTimeLineStream() {
        runBlocking {
            val stream = MisskeyStream(misskey())

            stream.client.openedCallback {
                println("opened.")
            }

            launch { stream.open() }
            delay(10 * 1000L)
            launch { stream.globalTimeline(Callback()) }
            delay(1000 * 1000L)
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
            println(note.text)
        }
    }
}
