package work.socialhub.kmisskey.api.response.notes

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.Note
import kotlin.js.JsExport

@JsExport
@Serializable
class NotesLocalTimelineResponse : Note()
