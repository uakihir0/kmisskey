package work.socialhub.kmisskey.stream.callback

import work.socialhub.kmisskey.entity.Note

interface RenoteCallback : EventCallback {
    fun onRenote(note: Note)
}
