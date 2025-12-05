package work.socialhub.kmisskey.api.response

import work.socialhub.kmisskey.entity.Note
import work.socialhub.kmisskey.entity.user.User
import kotlin.js.JsExport

/**
 * ap/show APIのレスポンス
 * object フィールドはオブジェクトとして返されるため、ApResourceImpl で手動パースする
 */
@JsExport
class ApShowResponse {
    var type: String? = null
    var note: Note? = null
    var user: User? = null
}
