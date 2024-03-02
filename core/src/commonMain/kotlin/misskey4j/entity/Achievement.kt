package misskey4j.entity

import kotlinx.serialization.Serializable

@Serializable
class Achievement {

    lateinit var name: String
    lateinit var unlockedAt: String
}