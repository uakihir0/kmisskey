package misskey4j.stream.client

interface WebSocketListener {
    fun onConnect()

    fun onMessage(message: String?)

    fun onMessage(data: ByteArray?)

    fun onDisconnect(code: Int, reason: String?)

    fun onError(error: Exception?)
}