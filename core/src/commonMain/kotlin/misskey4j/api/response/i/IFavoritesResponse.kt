package misskey4j.api.response.i

import kotlinx.serialization.Serializable
import misskey4j.entity.Note

@Serializable
class IFavoritesResponse {

    var id: String? = null
    var createdAt: String? = null
    var noteId: String? = null
    var note: Note? = null
}
