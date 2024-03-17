package work.socialhub.kmisskey.api.request

import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
class ReadAnnouncementRequest(
    val announcementId: String
) : TokenRequest()
