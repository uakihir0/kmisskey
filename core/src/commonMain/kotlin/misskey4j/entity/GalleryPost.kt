package misskey4j.entity

class GalleryPost {
    // region
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

    // endregion
    var likedCount: Int? = null
}
