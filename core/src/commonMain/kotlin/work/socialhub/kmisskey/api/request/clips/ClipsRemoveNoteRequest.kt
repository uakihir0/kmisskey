package work.socialhub.kmisskey.api.request.clips

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.api.model.TokenRequest
import kotlin.js.JsExport

@JsExport
@Serializable
class ClipsRemoveNoteRequest(
    val noteId: String,
    val clipId: String,
) : TokenRequest()
