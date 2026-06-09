package work.socialhub.kmisskey.api.request.drive

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.request.protocol.PagingTokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class DriveFilesRequest : PagingTokenRequest() {

    // 取得対象フォルダID (null の場合はルートフォルダ)
    var folderId: String? = null

    // MIME タイプによる絞り込み。
    // "image/jpeg" のような完全一致のほか、"image/*" 形式で前方一致 (image/ で始まるもの) も指定可能。
    var type: String? = null

    // ソート順。
    // "+createdAt", "-createdAt", "+name", "-name", "+size", "-size"
    var sort: String? = null
}
