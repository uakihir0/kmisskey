package work.socialhub.kmisskey.entity

import io.ktor.http.*
import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.user.UserLite
import kotlin.js.JsExport

/**
 * DriveFile
 * ファイルオブジェクト
 */
@JsExport
@Serializable
open class File {

    lateinit var id: String
    lateinit var createdAt: String

    lateinit var name: String
    lateinit var type: String
    lateinit var md5: String

    var size: Long = 0
    var isSensitive: Boolean = false
    var blurhash: String? = null

    var properties: FileProperties? = null

    lateinit var url: String
    var thumbnailUrl: String? = null

    var comment: String? = null
    var folderId: String? = null
    val folder: Folder? = null
    var userId: String? = null
    var user: UserLite? = null

    private fun extractForwardUrl(u: String?): String? {
        try {
            val structure = Url(u!!)
            val file = structure.fullPath
                .split("?").first()

            if (file.endsWith("image.webp")) {
                val queries = structure.encodedQuery
                    .split("&".toRegex())
                    .dropLastWhile { it.isEmpty() }
                    .toTypedArray()

                for (query in queries) {
                    val elements = query
                        .split("=".toRegex())
                        .dropLastWhile { it.isEmpty() }
                        .toTypedArray()

                    if (elements.size == 2 && elements[0] == "url") {
                        return elements[1].decodeURLPart()
                    }
                }
            }
            return null
        } catch (e: Exception) {
            return null
        }
    }

    fun extractedUrl(): String {
        return extractForwardUrl(url) ?: url
    }

    fun extractedThumbnailUrl(): String? {
        return extractForwardUrl(thumbnailUrl) ?: thumbnailUrl
    }

    @Serializable
    class FileProperties {
        var width = 0L
        var height = 0L
        var orientation = 0L
        var avgColor: String? = null
    }
}