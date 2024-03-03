package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.util.ColorDecoder

@Serializable
open class Instance {

    var name: String? = null
    var softwareName: String? = null
    var softwareVersion: String? = null
    var iconUrl: String? = null
    var faviconUrl: String? = null
    var themeColor: String? = null

    fun themeColorObject(): Color? {
        return themeColor?.let {
            ColorDecoder.decode(it)
        }
    }
}

