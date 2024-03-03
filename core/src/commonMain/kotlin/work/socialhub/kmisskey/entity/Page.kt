package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.user.User

@Serializable
class Page {

    lateinit var id: String
    lateinit var createdAt: String
    lateinit var updatedAt: String
    lateinit var userId: String

    /** UserLite */
    lateinit var user: User

    // TODO: PageBlock
    // var content: List<PageBlock> = listOf()
    // TODO: Objects?
    // var variables: List<Any> = listOf()

    lateinit var title: String
    lateinit var name: String
    var summary: String? = null

    var hideTitleWhenPinned = false
    var alignCenter = false

    lateinit var font: String
    lateinit var script: String

    var eyeCatchingImageId: String? = null
    // TODO: Image?
    // var eyeCatchingImage: Image? = null

    // TODO: DriveFile?
    // var attachedFiles: List<DriveFile> = listOf()

    var likedCount: Long = 0
    var isLiked = false
}