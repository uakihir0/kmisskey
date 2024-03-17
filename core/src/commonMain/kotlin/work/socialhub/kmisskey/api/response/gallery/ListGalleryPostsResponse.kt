package work.socialhub.kmisskey.api.response.gallery

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.GalleryPost
import kotlin.js.JsExport

@JsExport
@Serializable
class ListGalleryPostsResponse : GalleryPost()
