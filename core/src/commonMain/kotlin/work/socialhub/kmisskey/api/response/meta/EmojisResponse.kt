package work.socialhub.kmisskey.api.response.meta

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.Emoji

@Serializable
class EmojisResponse {
    var emojis: List<Emoji> = listOf()
}
