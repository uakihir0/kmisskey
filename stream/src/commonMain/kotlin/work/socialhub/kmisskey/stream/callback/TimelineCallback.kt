package work.socialhub.kmisskey.stream.callback

import work.socialhub.kmisskey.entity.Note

interface TimelineCallback : EventCallback {
    fun onNoteUpdate(note: Note)
}
