package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable

@Serializable
class SecurityKey {

    lateinit var id: String
    lateinit var name: String
    lateinit var lastUsed: String
}