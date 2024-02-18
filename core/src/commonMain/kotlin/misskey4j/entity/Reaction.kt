package misskey4j.entity

import kotlinx.serialization.Serializable

@Serializable
class Reaction {
    // TODO: emoji

    var noteId: String? = null
    lateinit var userId: String
    var reaction: String? = null
}
