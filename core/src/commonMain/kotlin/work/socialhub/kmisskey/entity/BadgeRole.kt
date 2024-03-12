package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class BadgeRole {

    lateinit var name: String
    var iconUrl: String? = null
    var displayOrder: Int = 0
}