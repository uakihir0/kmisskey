package misskey4j.entity

import kotlinx.serialization.Serializable

@Serializable
open class GalleryPost {

    var id: String? = null
    var createdAt: String? = null
    var updatedAt: String? = null
    var title: String? = null
    var description: String? = null

    var userId: String? = null
    var user: User? = null

    var fileIds: List<String>? = null
    var files: List<File>? = null

    var tags: List<String>? = null
    var sensitive: Boolean? = null

    var liked: Boolean? = null
    var likedCount: Int? = null
}
