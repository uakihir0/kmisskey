package misskey4j.entity

import kotlinx.serialization.Serializable

@Serializable
open class Field {
    var name: String? = null
    var value: String? = null
}
