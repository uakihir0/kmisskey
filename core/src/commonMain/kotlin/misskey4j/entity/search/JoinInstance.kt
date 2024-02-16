package misskey4j.entity.search

import io.ktor.http.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Join Misskey のインスタンスリストのオブジェクト
 * (https://instanceapp.misskey.page/instances.json)
 */
@Serializable
class JoinInstance {

    var url: String? = null
    var description: String? = null
    var langs: List<String>? = null

    var alive: Boolean = false
    var notSuspended: Boolean = false

    var meta: InstanceMeta? = null
    var stats: InstanceStats? = null

    @Serializable
    class InstanceMeta {

        var version: String? = null
        var uri: String? = null

        var iconUrl: String? = null
        var errorImageUrl: String? = null

        var bannerUrl: String? = null
        var maxNoteTextLength: Long? = null

        val supportedBannerUrl: String?
            get() {
                val original = bannerUrl
                if (!original.isNullOrEmpty()) {
                    try {
                        val host = Url(uri!!).host
                        return "https://instanceapp.misskey.page/instance-banners/$host.jpeg"
                    } catch (e: Exception) {
                        return null
                    }
                }
                return null
            }
    }

    @Serializable
    class InstanceStats {
        var notesCount: Long? = null
        var originalNotesCount: Long? = null
        var usersCount: Long? = null
        var originalUsersCount: Long? = null
        var instances: Long? = null
    }

    @Serializable
    class Instances {
        @SerialName("date")
        var timestamp: String? = null

        @SerialName("instancesInfos")
        var instances: List<JoinInstance>? = null
    }
}


