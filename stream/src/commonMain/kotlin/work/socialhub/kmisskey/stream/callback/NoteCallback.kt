package work.socialhub.kmisskey.stream.callback

import work.socialhub.kmisskey.entity.DeletedNote
import work.socialhub.kmisskey.entity.Reaction

interface NoteCallback : EventCallback {
    fun onReacted(reaction: Reaction)
    fun onUnreacted(reaction: Reaction)
    fun onNoteDeleted(note: DeletedNote)
}
