package work.socialhub.kmisskey.stream.callback

import work.socialhub.kmisskey.entity.Note

interface MentionCallback : EventCallback {
    fun onMention(note: Note)
}
