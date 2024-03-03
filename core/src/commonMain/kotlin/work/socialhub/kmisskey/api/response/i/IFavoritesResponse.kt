package work.socialhub.kmisskey.api.response.i

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.Note

@Serializable
class IFavoritesResponse {

    lateinit var id: String
    lateinit var createdAt: String
    lateinit var noteId: String
    lateinit var note: Note
}
