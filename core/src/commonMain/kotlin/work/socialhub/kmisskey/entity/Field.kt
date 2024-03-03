package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable

@Serializable
open class Field {
    var name: String? = null
    var value: String? = null
}
