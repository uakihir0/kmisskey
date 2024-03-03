package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable

@Serializable
open class Emojis {
    var list: List<Emoji> = listOf()
}
