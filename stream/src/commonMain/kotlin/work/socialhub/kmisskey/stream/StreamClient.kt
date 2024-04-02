package work.socialhub.kmisskey.stream

import work.socialhub.khttpclient.websocket.WebsocketRequest
import work.socialhub.kmisskey.entity.DeletedNote
import work.socialhub.kmisskey.entity.Note
import work.socialhub.kmisskey.entity.Notification
import work.socialhub.kmisskey.entity.Reaction
import work.socialhub.kmisskey.entity.user.User
import work.socialhub.kmisskey.internal.Internal
import work.socialhub.kmisskey.stream.callback.EventCallback
import work.socialhub.kmisskey.stream.callback.FollowedCallback
import work.socialhub.kmisskey.stream.callback.MentionCallback
import work.socialhub.kmisskey.stream.callback.NoteCallback
import work.socialhub.kmisskey.stream.callback.NotificationCallback
import work.socialhub.kmisskey.stream.callback.RenoteCallback
import work.socialhub.kmisskey.stream.callback.ReplayCallback
import work.socialhub.kmisskey.stream.callback.TimelineCallback
import work.socialhub.kmisskey.stream.model.StreamRequest
import work.socialhub.kmisskey.stream.model.StreamRequest.Body
import work.socialhub.kmisskey.stream.model.StreamResponse
import kotlin.random.Random.Default.nextInt

class StreamClient(
    var uri: String
) {
    var client = WebsocketRequest()
    var isOpen: Boolean = false

    var openedCallback: (() -> Unit)? = null
    var closedCallback: (() -> Unit)? = null
    var errorCallback: ((Exception) -> Unit)? = null

    fun openedCallback(callback: () -> Unit) = also { this.openedCallback = callback }
    fun closedCallback(callback: () -> Unit) = also { this.closedCallback = callback }
    fun errorCallback(callback: (Exception) -> Unit) = also { this.errorCallback = callback }

    private var eventCallbackMap = mutableMapOf<String, MutableList<EventCallback>>()

    init {
        this.client.url(this.uri)
        this.client.textListener = {
            this.onMessage(it)
        }
        this.client.onOpenListener = {
            this.isOpen = true
            this.openedCallback?.invoke()
        }
        this.client.onCloseListener = {
            this.isOpen = false
            this.closedCallback?.invoke()
        }
    }

    suspend fun open() {
        client.open()
    }

    fun close() {
        client.close()
    }

    /**
     * Add callback event handler
     */
    fun addEventCallback(
        id: String,
        callback: EventCallback
    ) {
        eventCallbackMap.let { map ->
            map[id] = (map[id] ?: mutableListOf())
                .also { it.add(callback) }
        }
    }

    /**
     * Subscribe
     */
    suspend inline fun <reified T> subscribe(
        type: String,
        channel: String,
        id: String,
        params: T,
        callbacks: List<EventCallback> = listOf()
    ) {
        val request = StreamRequest(
            type = type,
            body = Body(
                id = id,
                channel = channel,
                params = params,
            )
        )

        callbacks.forEach { cb ->
             addEventCallback(id, cb)
        }

        val text = Internal.toJson(request)
        println(text)
        client.sendText(text)
    }

    suspend inline fun <reified T> connect(
        channel: String,
        params: T,
        callbacks: List<EventCallback> = listOf()
    ) {
        subscribe(
            "connect",
            channel,
            randomId(),
            params,
            callbacks
        )
    }

    suspend fun disconnect(
        channel: String
    ) {
        subscribe<Any?>(
            "disconnect",
            channel,
            "",
            ""
        )
    }

    suspend inline fun <reified T> subscribeToNote(
        id: String,
        params: T,
        callbacks: List<EventCallback> = listOf()
    ) {
        subscribe(
            "subNote",
            "",
            id,
            params,
            callbacks,
        )
    }

    suspend fun unsubscribe(
        id: String
    ) {
        subscribe(
            "unsubNote",
            "",
            id,
            "",
        )
    }


    fun onMessage(
        message: String
    ) {
        val response: StreamResponse<StreamResponse.BodyOnlyType> =
            Internal.fromJson(message)

        if (response.type == "channel") {

            // NOTE
            if (response.body.type == "note") {
                val noteType: StreamResponse<StreamResponse.BodyWithBody<Note>> =
                    Internal.fromJson(message)

                val events = eventCallbackMap[noteType.body.id]
                if (events != null && events.size > 0) {
                    for (event in events) {
                        if (event is TimelineCallback) {
                            val body = noteType.body.body
                            event.onNoteUpdate(body)
                        }
                    }
                }
            }

            // REPLY
            if (response.body.type == "reply") {
                val noteType: StreamResponse<StreamResponse.BodyWithBody<Note>> =
                    Internal.fromJson(message)

                val events = eventCallbackMap[noteType.body.id]
                if (events != null && events.size > 0) {
                    for (event in events) {
                        if (event is ReplayCallback) {
                            val body = noteType.body.body
                            event.onReply(body)
                        }
                    }
                }
            }

            // MENTION
            if (response.body.type == "mention") {
                val noteType: StreamResponse<StreamResponse.BodyWithBody<Note>> =
                    Internal.fromJson(message)

                val events = eventCallbackMap[noteType.body.id]
                if (events != null && events.size > 0) {
                    for (event in events) {
                        if (event is MentionCallback) {
                            val body = noteType.body.body
                            event.onMention(body)
                        }
                    }
                }
            }

            // RENOTE
            if (response.body.type == "renote") {
                val noteType: StreamResponse<StreamResponse.BodyWithBody<Note>> =
                    Internal.fromJson(message)

                val events = eventCallbackMap[noteType.body.id]
                if (events != null && events.size > 0) {
                    for (event in events) {
                        if (event is RenoteCallback) {
                            val body = noteType.body.body
                            event.onRenote(body)
                        }
                    }
                }
            }

            // FOLLOWED
            if (response.body.type == "followed") {
                val userType: StreamResponse<StreamResponse.BodyWithBody<User>> =
                    Internal.fromJson(message)

                val events = eventCallbackMap[userType.body.id]
                if (events != null && events.size > 0) {
                    for (event in events) {
                        if (event is FollowedCallback) {
                            val body = userType.body.body
                            event.onFollowed(body)
                        }
                    }
                }
            }

            // Notification
            if (response.body.type == "notification") {
                val notificationType: StreamResponse<StreamResponse.BodyWithBody<Notification>> =
                    Internal.fromJson(message)

                val events = eventCallbackMap[notificationType.body.id]
                if (events != null && events.size > 0) {
                    for (event in events) {
                        if (event is NotificationCallback) {
                            val body = notificationType.body.body
                            event.onNotification(body)
                        }
                    }
                }
            }

        } else if (response.type == "noteUpdated") {

            // REACTED
            if (response.body.type == "reacted") {
                val reactionType: StreamResponse<StreamResponse.BodyWithBody<Reaction>> =
                    Internal.fromJson(message)

                val events = eventCallbackMap[reactionType.body.id]
                if (events != null && events.size > 0) {
                    for (event in events) {
                        if (event is NoteCallback) {
                            val body = reactionType.body.body
                            body.noteId = response.body.id
                            event.onReacted(body)
                        }
                    }
                }
            }

            // UNREACTED
            if (response.body.type == "unreacted") {
                val reactionType: StreamResponse<StreamResponse.BodyWithBody<Reaction>> =
                    Internal.fromJson(message)

                val events = eventCallbackMap[reactionType.body.id]
                if (events != null && events.size > 0) {
                    for (event in events) {
                        if (event is NoteCallback) {
                            val body = reactionType.body.body
                            body.noteId = response.body.id
                            event.onUnreacted(body)
                        }
                    }
                }
            }

            // DELETED
            if (response.body.type == "deleted") {
                val deleteNoteType: StreamResponse<StreamResponse.BodyWithBody<DeletedNote>> =
                    Internal.fromJson(message)

                val events = eventCallbackMap[deleteNoteType.body.id]
                if (events != null && events.size > 0) {
                    for (event in events) {
                        if (event is NoteCallback) {
                            val body = deleteNoteType.body.body
                            body.id = response.body.id
                            event.onNoteDeleted(body)
                        }
                    }
                }
            }

            // TODO: PollVoted
        }
    }

    fun randomId(): String {
        return (1..16)
            .joinToString("") {
                nextInt(0, 16)
                    .toString(16)
            }
    }
}
