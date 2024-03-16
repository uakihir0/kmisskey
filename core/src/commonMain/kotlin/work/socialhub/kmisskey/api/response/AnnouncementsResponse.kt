package work.socialhub.kmisskey.api.response

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.Announcements
import kotlin.js.JsExport

@JsExport
@Serializable
class AnnouncementsResponse : Announcements()
