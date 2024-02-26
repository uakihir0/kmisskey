package misskey4j.stream

import misskey4j.entity.Note
import misskey4j.entity.Notification
import misskey4j.entity.User
import misskey4j.internal.Internal
import misskey4j.stream.callback.ClosedCallback
import misskey4j.stream.callback.ErrorCallback
import misskey4j.stream.callback.EventCallback
import misskey4j.stream.callback.OpenedCallback
import misskey4j.stream.model.StreamRequest
import misskey4j.stream.model.StreamResponse
import work.socialhub.khttpclient.websocket.WebsocketRequest

class StreamClient(
    var uri: String
) {
    var client = WebsocketRequest()
    var isOpen: Boolean = false

    var eventCallback: EventCallback? = null
    private var openedCallback: OpenedCallback? = null
    private var closedCallback: ClosedCallback? = null
    private var errorCallback: ErrorCallback? = null

    fun eventCallback(callback: EventCallback) = also { this.eventCallback = callback }
    fun openedCallback(callback: OpenedCallback) = also { this.openedCallback = callback }
    fun closedCallback(callback: ClosedCallback) = also { this.closedCallback = callback }
    fun errorCallback(callback: ErrorCallback) = also { this.errorCallback = callback }

    init {
        this.client.url(this.uri)
        this.client.textListener = {
            this.onMessage(it)
        }
        this.client.onOpenListener = {
            this.isOpen = true
            this.openedCallback?.onOpened()
        }
        this.client.onCloseListener = {
            this.isOpen = false
            this.closedCallback?.onClosed()
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
    fun addCallback(id: String?, callbacks: List<EventCallback>) {
        callbackMap[id] = callbacks
    }

    /**
     * Subscribe
     */
    suspend fun <T> subscribe(
        type: String,
        channelType: String?,
        id: String?,
        params: T,
        possibleCallbacks: List<EventCallback>?
    ) {
        val request: StreamRequest<T> = StreamRequest()

        possibleCallbacks?.let {
            addCallback(id, it)
        }

        request.body.channel = channelType
        request.body.params = params
        request.body.id = id
        request.type = type

        val text = Internal.toJson(request)
        client.sendText(text)
    }

    suspend fun <T> connect(
        channelType: String?,
        params: T?,
        callbacks: List<EventCallback>?
    ) {
        subscribe<T?>(
            "connect",
            channelType,
            java.util.UUID.randomUUID().toString(),
            params,
            callbacks
        )
    }

    suspend fun <T> disconnect(
        channelType: String?
    ) {
        subscribe<Any?>(
            "disconnect",
            channelType,
            null,
            null,
            null
        )
    }

    suspend fun <T> subscribeToNote(
        id: String?,
        params: T?,
        callbacks: List<EventCallback>?
    ) {
        subscribe(
            "subNote",
            null,
            id,
            params,
            callbacks
        )
    }

    suspend fun <T> unsubscribe(
        id: String?
    ) {
        subscribe<Any?>(
            "unsubNote",
            null,
            id,
            null,
            null
        )
    }


    fun onMessage(message: String) {
        val response : StreamResponse<Any> = Internal.fromJson(message)

        if (generic.getType().equals("channel")) {
            // NOTE

            if (generic.getBody().getType().equals("note")) {
                val noteType: java.lang.reflect.Type = object : TypeToken<StreamResponse<Note?>?>() {
                }.getType()

                val note: StreamResponse<Note> = gson.fromJson(message, noteType)
                val events: List<EventCallback>? = callbackMap[generic.getBody().getId()]

                if (events != null && events.size > 0) {
                    for (event in events) {
                        if (event is TimelineCallback) {
                            val body: Note = note.getBody().getBody()
                            (event as TimelineCallback).onNoteUpdate(body)
                        }
                    }
                }
            }

            // REPLY
            if (generic.getBody().getType().equals("reply")) {
                val noteType: java.lang.reflect.Type = object : TypeToken<StreamResponse<Note?>?>() {
                }.getType()

                val note: StreamResponse<Note> = gson.fromJson(message, noteType)
                val events: List<EventCallback>? = callbackMap[generic.getBody().getId()]

                if (events != null && events.size > 0) {
                    for (event in events) {
                        if (event is ReplayCallback) {
                            val body: Note = note.getBody().getBody()
                            (event as ReplayCallback).onReply(body)
                        }
                    }
                }
            }

            // MENTION
            if (generic.getBody().getType().equals("mention")) {
                val noteType: java.lang.reflect.Type = object : TypeToken<StreamResponse<Note?>?>() {
                }.getType()

                val note: StreamResponse<Note> = gson.fromJson(message, noteType)
                val events: List<EventCallback>? = callbackMap[generic.getBody().getId()]

                if (events != null && events.size > 0) {
                    for (event in events) {
                        if (event is MentionCallback) {
                            val body: Note = note.getBody().getBody()
                            (event as MentionCallback).onMention(body)
                        }
                    }
                }
            }

            // RENOTE
            if (generic.getBody().getType().equals("renote")) {
                val noteType: java.lang.reflect.Type = object : TypeToken<StreamResponse<Note?>?>() {
                }.getType()

                val note: StreamResponse<Note> = gson.fromJson(message, noteType)
                val events: List<EventCallback>? = callbackMap[generic.getBody().getId()]

                if (events != null && events.size > 0) {
                    for (event in events) {
                        if (event is RenoteCallback) {
                            val body: Note = note.getBody().getBody()
                            (event as RenoteCallback).onRenote(body)
                        }
                    }
                }
            }

            // FOLLOWED
            if (generic.getBody().getType().equals("followed")) {
                val userType: java.lang.reflect.Type = object : TypeToken<StreamResponse<User?>?>() {
                }.getType()

                val user: StreamResponse<User> = gson.fromJson(message, userType)
                val events: List<EventCallback>? = callbackMap[generic.getBody().getId()]

                if (events != null && events.size > 0) {
                    for (event in events) {
                        if (event is FollowedCallback) {
                            val body: User = user.getBody().getBody()
                            (event as FollowedCallback).onFollowed(body)
                        }
                    }
                }
            }

            // Notification
            if (generic.getBody().getType().equals("notification")) {
                val notificationType: java.lang.reflect.Type = object : TypeToken<StreamResponse<Notification?>?>() {
                }.getType()

                val notification: StreamResponse<Notification> = gson.fromJson(message, notificationType)
                val events: List<EventCallback>? = callbackMap[generic.getBody().getId()]

                if (events != null && events.size > 0) {
                    for (event in events) {
                        if (event is NotificationCallback) {
                            val body: Notification = notification.getBody().getBody()
                            (event as NotificationCallback).onNotification(body)
                        }
                    }
                }
            }
        } else if (generic.getType().equals("noteUpdated")) {
            // REACTED

            if (generic.getBody().getType().equals("reacted")) {
                val noteType: java.lang.reflect.Type = object : TypeToken<StreamResponse<Reaction?>?>() {
                }.getType()

                val note: StreamResponse<Reaction> = gson.fromJson(message, noteType)
                val events: List<EventCallback>? = callbackMap[generic.getBody().getId()]

                if (events != null && events.size > 0) {
                    for (event in events) {
                        if (event is NoteCallback) {
                            val body: Reaction = note.getBody().getBody()
                            body.noteId = generic.getBody().getId()
                            (event as NoteCallback).onReacted(body)
                        }
                    }
                }
            }

            // UNREACTED
            if (generic.getBody().getType().equals("unreacted")) {
                val noteType: java.lang.reflect.Type = object : TypeToken<StreamResponse<Reaction?>?>() {
                }.getType()

                val note: StreamResponse<Reaction> = gson.fromJson(message, noteType)
                val events: List<EventCallback>? = callbackMap[generic.getBody().getId()]

                if (events != null && events.size > 0) {
                    for (event in events) {
                        if (event is NoteCallback) {
                            val body: Reaction = note.getBody().getBody()
                            body.noteId = generic.getBody().getId()
                            (event as NoteCallback).onUnreacted(body)
                        }
                    }
                }
            }

            // DELETED
            if (generic.getBody().getType().equals("deleted")) {
                val noteType: java.lang.reflect.Type = object : TypeToken<StreamResponse<DeletedNote?>?>() {
                }.getType()

                val note: StreamResponse<DeletedNote> = gson.fromJson(message, noteType)
                val events: List<EventCallback>? = callbackMap[generic.getBody().getId()]

                if (events != null && events.size > 0) {
                    for (event in events) {
                        if (event is NoteCallback) {
                            val body: DeletedNote = note.getBody().getBody()
                            body.id = generic.getBody().getId()
                            (event as NoteCallback).onNoteDeleted(body)
                        }
                    }
                }
            }

            // TODO: PollVoted
        }

        logger.trace(message)
    }

    fun onDisconnect(code: Int, reason: String) {
        logger.debug("Connection closed, code: $code reason: $reason")
        this.isOpen = false

        if (closedCallback != null) {
            closedCallback.onClosed(false)
        }
    }

    fun onError(cause: java.lang.Exception?) {
        if (cause != null) {
            logger.debug(
                "Exception: " + cause.javaClass.getName()
                        + " message: " + cause.message
            )
            logger.debug("Trace: ", cause)
        }

        if (errorCallback != null) {
            errorCallback.onError(cause)
        }
    }

    fun onMessage(data: ByteArray?) {
    }

    // region
    fun setOpenedCallback(openedCallback: OpenedCallback?) {
        this.openedCallback = openedCallback
    }

    fun setClosedCallback(closedCallback: ClosedCallback?) {
        this.closedCallback = closedCallback
    }

    fun setErrorCallback(errorCallback: ErrorCallback?) {
        this.errorCallback = errorCallback
    } // endregion

    companion object {
        private val logger: Logger = Logger.getLogger(StreamClient::class.java)
    }
}
