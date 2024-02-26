package misskey4j.stream.callback

import misskey4j.entity.Note

interface TimelineCallback : EventCallback {
    fun onNoteUpdate(note: Note)
}
