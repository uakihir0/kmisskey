package misskey4j.entity

import io.ktor.http.*
import kotlinx.serialization.Serializable

/**
 * ファイルオブジェクト
 */
@Serializable
class File {

    var id: String? = null
    var createdAt: String? = null
    var name: String? = null
    var type: String? = null
    var size: Long? = null
    var sensitive =  false
    var blurhash: String? = null

    var originalUrl: String? = null
    var originalThumbnailUrl: String? = null

    var comment: String? = null
    var folderId: String? = null
    var userId: String? = null

    fun extractForwardUrl(u: String?): String? {
        try {
            val structure = Url(u!!)
            if (structure.fullPath.endsWith("image.webp")) {
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

    fun url(): String {
        return extractForwardUrl(originalUrl) ?: originalUrl!!
    }

    fun thumbnailUrl(): String {
        return extractForwardUrl(originalThumbnailUrl) ?: originalThumbnailUrl!!
    }
}