package misskey4j.stream.callback

interface ClosedCallback {
    fun onClosed(remote: Boolean)
}
