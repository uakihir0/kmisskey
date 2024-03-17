package work.socialhub.kmisskey.api.response.blocks

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.Block
import kotlin.js.JsExport

@JsExport
@Serializable
class BlocksListResponse : Block()
