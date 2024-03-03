package work.socialhub.kmisskey.stream.callback

import work.socialhub.kmisskey.entity.Note

interface ReplayCallback : EventCallback {
    fun onReply(note: Note)
}
