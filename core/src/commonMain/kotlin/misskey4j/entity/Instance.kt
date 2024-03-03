package misskey4j.entity

import kotlinx.serialization.Serializable
import misskey4j.util.ColorDecoder

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

