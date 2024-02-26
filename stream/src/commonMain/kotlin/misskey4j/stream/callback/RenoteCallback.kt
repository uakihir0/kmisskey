package misskey4j.stream.callback

import misskey4j.entity.Note

interface RenoteCallback : EventCallback {
    fun onRenote(note: Note)
}
