package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.user.User
import kotlin.js.JsExport

@JsExport
@Serializable
class Page {

    lateinit var id: String
    lateinit var createdAt: String
    lateinit var updatedAt: String
    lateinit var userId: String

    /** UserLite */
    lateinit var user: User

    var content: Array<PageContent>? = null
    var variables: Array<PageVariable>? = null

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

    var likedCount: Int = 0
    var isLiked = false
}

@JsExport
@Serializable
class PageContent {
    var id: String? = null
    var type: String? = null
    var text: String? = null
    var fileId: String? = null
    var width: Int? = null
    var height: Int? = null
    var noteId: String? = null
    var imageId: String? = null
    var image: String? = null
    var title: String? = null
    var url: String? = null
    var children: Array<PageContent>? = null
    var name: String? = null
    var value: String? = null
    var inc: Int? = null
    var canvasId: String? = null
    var isPayer: Boolean? = null
    var payerId: String? = null
    var payerName: String? = null
    var payerUsername: String? = null
    var payerAvatarUrl: String? = null
    var paidAt: String? = null
}

@JsExport
@Serializable
class PageVariable {
    var name: String? = null
    var type: String? = null
    var value: String? = null
}