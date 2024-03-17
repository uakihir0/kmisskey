package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class SecurityKey {

    lateinit var id: String
    lateinit var name: String
    lateinit var lastUsed: String
}