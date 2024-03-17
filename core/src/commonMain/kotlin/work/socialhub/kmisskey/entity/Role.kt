package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Role {

    lateinit var id: String
    lateinit var name: String
    var color: Color? = null
    var iconUrl: String? = null
    var displayOrder: Int = 0
}
