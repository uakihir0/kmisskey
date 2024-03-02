package misskey4j.entity

import kotlinx.serialization.Serializable

@Serializable
class Achievement {

    lateinit var name: String

    // TODO: String literal for key 'unlockedAt' should be quoted.
    // lateinit var unlockedAt: String
}