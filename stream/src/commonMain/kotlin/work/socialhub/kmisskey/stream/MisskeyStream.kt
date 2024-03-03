package work.socialhub.kmisskey.stream

import work.socialhub.kmisskey.Misskey
import work.socialhub.kmisskey.stream.callback.EventCallback
import work.socialhub.kmisskey.stream.callback.NoteCallback
import work.socialhub.kmisskey.stream.callback.TimelineCallback

class MisskeyStream(
    misskey: Misskey
) {
    val url: String
    val client: StreamClient

    init {
        val host = misskey.host
        val i = checkNotNull(misskey.i)
        url = "wss://$host/streaming?i=$i"
        client = StreamClient(url)
    }

    /**
     * Is connection opened?
     */
    val isOpen: Boolean
        get() = client.isOpen

    /**
     * Connect (nonblocking)
     */
    suspend fun open() {
        client.open()
    }

    /**
     * Close
     */
    fun close() {
        client.close()
    }

    /**
     * Notifications
     */
    suspend fun main(
        callback: EventCallback
    ) {
        client.connect(
            "main",
            null,
            listOf(callback)
        )
    }

    /**
     * HomeTimeLine Events
     */
    suspend fun homeTimeLine(
        callback: TimelineCallback
    ) {
        client.connect(
            "homeTimeline",
            null,
            listOf(callback)
        )
    }

    /**
     * LocalTimeline Events
     */
    suspend fun localTimeline(
        callback: TimelineCallback
    ) {
        client.connect(
            "localTimeline",
            null,
            listOf(callback),
        )
    }

    /**
     * HybridTimeline Events
     */
    suspend fun hybridTimeline(
        callback: TimelineCallback
    ) {
        client.connect(
            "hybridTimeline",
            null,
            listOf(callback),
        )
    }

    /**
     * GlobalTimeline Events
     */
    suspend fun globalTimeline(
        callback: TimelineCallback
    ) {
        client.connect(
            "globalTimeline",
            null,
            listOf(callback),
        )
    }

    /**
     * Listen note Events
     */
    suspend fun note(
        noteId: String,
        callback: NoteCallback
    ) {
        client.subscribeToNote(
            noteId,
            null,
            listOf(callback),
        )
    }

    fun unsubscribe(): Unsubscribe {
        return Unsubscribe(client)
    }


    inner class Unsubscribe(
        val client: StreamClient
    ) {

        /**
         * Notifications
         */
        suspend fun main() {
            client.disconnect("main")
        }

        /**
         * HomeTimeLine Events
         */
        suspend fun homeTimeLine() {
            client.disconnect("homeTimeline")
        }

        /**
         * LocalTimeline Events
         */
        suspend fun localTimeline() {
            client.disconnect("localTimeline")
        }

        /**
         * HybridTimeline Events
         */
        suspend fun hybridTimeline() {
            client.disconnect("hybridTimeline")
        }

        /**
         * GlobalTimeline Events
         */
        suspend fun globalTimeline() {
            client.disconnect("globalTimeline")
        }

        /**
         * Stop listening to note Events
         */
        suspend fun note(noteId: String) {
            client.unsubscribe(noteId)
        }
    }
}
