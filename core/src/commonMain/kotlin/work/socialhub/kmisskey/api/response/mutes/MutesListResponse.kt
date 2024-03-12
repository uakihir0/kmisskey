package work.socialhub.kmisskey.api.response.mutes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.Mute
import kotlin.js.JsExport

@JsExport
@Serializable
class MutesListResponse : Mute()
