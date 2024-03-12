package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
open class Poll {
    var multiple = false
    var expiresAt: String? = null
    var choices: Array<Choice>? = null
}
