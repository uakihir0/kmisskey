package misskey4j.stream.callback

interface ErrorCallback {
    fun onError(e: Exception)
}
