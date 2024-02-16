package misskey4j.entity

import kotlinx.serialization.Serializable

@Serializable
class Choice {
    // region
    var text: String? = null
    var votes: Long? = null

    // endregion
    var voted: Boolean? = null
        get() = if ((field != null)) field else false
}

