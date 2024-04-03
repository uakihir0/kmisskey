package work.socialhub.kmisskey.entity.user

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.Color
import work.socialhub.kmisskey.entity.Field
import work.socialhub.kmisskey.entity.Note
import work.socialhub.kmisskey.entity.Page
import work.socialhub.kmisskey.util.BlurHashDecoder
import kotlin.js.JsExport

@JsExport
@Serializable
open class UserDetailedNotMe : UserLite() {

    var url: String? = null
    var uri: String? = null

    var moveTo: String? = null
    var alsoKnownAs: Array<String> = arrayOf()

    lateinit var createdAt: String
    var updatedAt: String? = null
    var lastFetchedAt: String? = null

    var bannerUrl: String? = null
    var bannerBlurhash: String? = null

    var isLocked: Boolean = false
    var isSilenced: Boolean = false
    var isLimited: Boolean = false
    var isSuspended: Boolean = false

    var description: String? = null
    var location: String? = null
    var birthday: String? = null
    var lang: String? = null

    var fields: Array<Field> = arrayOf()
    var verifiedLinks: Array<String> = arrayOf()

    var followersCount: Int = 0
    var followingCount: Int = 0
    var notesCount: Int = 0

    var pinnedNoteIds: Array<String> = arrayOf()
    var pinnedNotes: Array<Note> = arrayOf()

    var pinnedPageId: String? = null
    var pinnedPage: Page? = null

    var publicReactions: Boolean = false

    lateinit var followingVisibility: String
    lateinit var followersVisibility: String

    var twoFactorEnabled: Boolean = false
    var usePasswordLessLogin: Boolean = false
    var securityKeys: Boolean = false

    // TODO: RoleLite
    // var roles: List<RoleLite> = listOf()

    var memo: String? = null

    var moderationNote: String? = null

    var isFollowing: Boolean = false
    var isFollowed: Boolean = false

    var hasPendingFollowRequestFromYou: Boolean = false
    var hasPendingFollowRequestToYou: Boolean = false

    var isBlocking: Boolean = false
    var isBlocked: Boolean = false
    var isMuted: Boolean = false
    var isRenoteMuted: Boolean = false

    var notify: String? = null
    var withReplies: Boolean = false

    /*
     * The following are original items.
     * 以下、独自項目
     */
    var bannerColor: Color? = null
        get() {
            if (field == null) {
                val decoder = BlurHashDecoder.instance
                val ary = decoder.decode(
                    bannerBlurhash,
                    1,
                    1,
                    1F,
                    false
                ) ?: return null

                val color = Color()
                color.r = ary[0][0][0]
                color.g = ary[0][0][1]
                color.b = ary[0][0][2]
                return color
            }
            return field
        }
}