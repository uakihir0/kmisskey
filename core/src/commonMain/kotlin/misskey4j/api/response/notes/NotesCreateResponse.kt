package misskey4j.api.response.notes

import kotlinx.serialization.Serializable
import misskey4j.entity.Note

@Serializable
class NotesCreateResponse {
    lateinit var createdNote: Note
}
