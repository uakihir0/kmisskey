package work.socialhub.kmisskey.api.request.pages

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import work.socialhub.kmisskey.entity.PageContent
import work.socialhub.kmisskey.entity.PageVariable
import kotlin.js.JsExport

@JsExport
@Serializable
class PagesCreateRequest : TokenRequest() {
    var title: String? = null
    var name: String? = null
    var summary: String? = null
    var content: Array<PageContent>? = null
    var variables: Array<PageVariable>? = null
    var script: String? = null
    var eyeCatchingImageId: String? = null
    var font: String? = null
    var alignCenter: Boolean? = null
    var hideTitleWhenPinned: Boolean? = null
}
