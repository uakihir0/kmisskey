package work.socialhub.kmisskey.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
open class Choice {

    var text: String? = null
    var votes: Int? = null

    @SerialName("isVoted")
    var voted = false
}

