package misskey4j.entity

import kotlinx.serialization.Serializable

@Serializable
open class Emojis {
    var list: List<Emoji> = listOf()
}
