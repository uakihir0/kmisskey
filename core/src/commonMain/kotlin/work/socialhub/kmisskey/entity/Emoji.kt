package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
open class Emoji {

    /** up to v12  */
    @Deprecated("")
    var id: String? = null

    /** up to v12  */
    @Deprecated("")
    var host: String? = null

    lateinit var name: String
    lateinit var url: String
    lateinit var category: String

    var aliases: Array<String>? = null

    /** added in calckey.jp/Misskey v14.0.0-rc-ni-jp1)  */
    var width: Int? = null
    var height: Int? = null
}

