package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable

@Serializable
class BadgeRole {

    lateinit var name: String
    var iconUrl: String? = null
    var displayOrder: Int = 0
}