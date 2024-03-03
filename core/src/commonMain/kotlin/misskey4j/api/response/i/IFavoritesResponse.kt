package misskey4j.api.response.i

import kotlinx.serialization.Serializable
import misskey4j.entity.Note

@Serializable
class IFavoritesResponse {

    lateinit var id: String
    lateinit var createdAt: String
    lateinit var noteId: String
    lateinit var note: Note
}
