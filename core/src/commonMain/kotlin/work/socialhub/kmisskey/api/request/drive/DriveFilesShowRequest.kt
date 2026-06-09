package work.socialhub.kmisskey.api.request.drive

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class DriveFilesShowRequest : TokenRequest() {

    // 取得対象のファイルID
    var fileId: String? = null

    // ファイルID の代わりに URL で指定する場合
    var url: String? = null
}
