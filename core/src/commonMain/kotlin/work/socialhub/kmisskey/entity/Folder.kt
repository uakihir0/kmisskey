package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable

@Serializable
class Folder {

    lateinit var id: String
    lateinit var createdAt: String
    lateinit var name: String

    var parentId: String? = null
    var foldersCount: Long = 0
    var filesCount: Long = 0
    var parent: Folder? = null
}