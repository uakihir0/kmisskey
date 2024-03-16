package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Achievement {

    lateinit var name: String

    // TODO: String literal for key 'unlockedAt' should be quoted.
    // lateinit var unlockedAt: String
}