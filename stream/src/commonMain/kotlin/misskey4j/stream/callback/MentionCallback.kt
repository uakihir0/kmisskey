package misskey4j.stream.callback

import misskey4j.entity.Note

interface MentionCallback : EventCallback {
    fun onMention(note: Note?)
}
