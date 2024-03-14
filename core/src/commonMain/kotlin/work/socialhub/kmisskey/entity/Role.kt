package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable

@Serializable
class Role {

    lateinit var id: String
    lateinit var name: String
    var color: Color? = null
    var iconUrl: String? = null
    var displayOrder: Long = 0
}
