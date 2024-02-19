package misskey4j.api.response.meta

import kotlinx.serialization.Serializable
import misskey4j.entity.Emoji

@Serializable
class EmojisResponse {
    var emojis: List<Emoji> = listOf()
}
