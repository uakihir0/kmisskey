package work.socialhub.kmisskey.api.request.drive

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.request.protocol.PagingTokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class DriveFoldersRequest : PagingTokenRequest() {

    // 取得対象の親フォルダID (null の場合はルートフォルダ)
    var folderId: String? = null
}
