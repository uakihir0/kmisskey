package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Folder {

    lateinit var id: String
    lateinit var createdAt: String
    lateinit var name: String

    var parentId: String? = null
    var foldersCount: Int = 0
    var filesCount: Int = 0
    var parent: Folder? = null
}