package misskey4j.stream.callback

import misskey4j.entity.Note

interface ReplayCallback : EventCallback {
    fun onReply(note: Note)
}
