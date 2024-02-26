package misskey4j.stream

import kotlinx.coroutines.runBlocking
import misskey4j.Misskey
import misskey4j.stream.callback.EventCallback
import work.socialhub.khttpclient.websocket.WebsocketRequest

class MisskeyStream(
    val misskey: Misskey
) {
    val url: String

    init {
        val host = misskey.host
        val i = checkNotNull(misskey.i)
        url = "wss://$host/streaming?i=$i"
    }

    val isOpen: Boolean
        /**
         * Is connection opened?
         */
        get() = client!!.isOpen()

    /**
     * Connect (nonblocking)
     */
    fun connect() {
        client!!.connect()
    }

    /**
     * Close
     */
    fun close() {
        client!!.close()
    }

    /**
     * Notifications
     */
    fun main():StreamClient {
        StreamClient(url)

    }

    /**
     * HomeTimeLine Events
     */
    fun homeTimeLine(callback: TimelineCallback) {
        client!!.connect("homeTimeline", null, listOf<Any>(callback))
    }

    /**
     * LocalTimeline Events
     */
    fun localTimeline(callback: TimelineCallback) {
        client!!.connect("localTimeline", null, listOf<Any>(callback))
    }

    /**
     * HybridTimeline Events
     */
    fun hybridTimeline(callback: TimelineCallback) {
        client!!.connect("hybridTimeline", null, listOf<Any>(callback))
    }

    /**
     * GlobalTimeline Events
     */
    fun globalTimeline(callback: TimelineCallback) {
        client!!.connect("globalTimeline", null, listOf<Any>(callback))
    }

    /**
     * Listen note Events
     */
    fun note(noteId: String?, callback: NoteCallback) {
        client!!.subscribeToNote(noteId, null, listOf<Any>(callback))
    }

    @CheckReturnValue
    fun unsubscribe(): Unsubscribe {
        return Unsubscribe(client)
    }

    fun setOpenedCallback(openedCallback: OpenedCallback?) {
        client!!.setOpenedCallback(openedCallback)
    }

    fun setClosedCallback(closedCallback: ClosedCallback?) {
        client!!.setClosedCallback(closedCallback)
    }

    fun setErrorCallback(errorCallback: ErrorCallback?) {
        client!!.setErrorCallback(errorCallback)
    }

    inner class Unsubscribe(client: StreamClient) {
        private val client: StreamClient = client

        /**
         * Notifications
         */
        fun main() {
            client.disconnect<Any>("main")
        }

        /**
         * HomeTimeLine Events
         */
        fun homeTimeLine() {
            client.disconnect<Any>("homeTimeline")
        }

        /**
         * LocalTimeline Events
         */
        fun localTimeline() {
            client.disconnect<Any>("localTimeline")
        }

        /**
         * HybridTimeline Events
         */
        fun hybridTimeline() {
            client.disconnect<Any>("hybridTimeline")
        }

        /**
         * GlobalTimeline Events
         */
        fun globalTimeline() {
            client.disconnect<Any>("globalTimeline")
        }

        /**
         * Stop listening to note Events
         */
        fun note(noteId: String?) {
            client.unsubscribe<Any>(noteId)
        }
    }
}
