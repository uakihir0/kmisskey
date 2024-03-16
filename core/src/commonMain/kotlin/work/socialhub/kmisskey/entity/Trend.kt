package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
open class Trend {
    var tag: String? = null
    var chart: Array<Int>? = null
    var usersCount: Int? = null
}
