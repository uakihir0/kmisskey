package misskey4j.stream.callback

import misskey4j.entity.DeletedNote
import misskey4j.entity.Reaction

interface NoteCallback : EventCallback {
    fun onReacted(reaction: Reaction)
    fun onUnreacted(reaction: Reaction)
    fun onNoteDeleted(note: DeletedNote)
}
