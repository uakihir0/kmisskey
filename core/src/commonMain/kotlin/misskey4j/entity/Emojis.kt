package misskey4j.entity

import kotlinx.serialization.Serializable

@Serializable
class Emojis {
    var list: List<Emoji> = listOf()
}
