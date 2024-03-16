package work.socialhub.kmisskey.api.response.files

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.File
import kotlin.js.JsExport

@JsExport
@Serializable
class FilesCreateResponse : File()
