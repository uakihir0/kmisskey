package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.user.User
import kotlin.js.JsExport

@JsExport
@Serializable
open class GalleryPost {

    var id: String? = null
    var createdAt: String? = null
    var updatedAt: String? = null
    var title: String? = null
    var description: String? = null

    var userId: String? = null
    var user: User? = null

    var fileIds: Array<String> = arrayOf()
    var files: Array<File> = arrayOf()

    var tags: Array<String> = arrayOf()
    var sensitive: Boolean = false

    var liked: Boolean = false
    var likedCount: Int? = null
}
