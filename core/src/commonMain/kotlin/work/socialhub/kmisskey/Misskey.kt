package work.socialhub.kmisskey

import work.socialhub.kmisskey.api.AnnouncementsResource
import work.socialhub.kmisskey.api.*
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport
interface Misskey {

    fun meta(): MetaResource
    fun announcements(): AnnouncementsResource
    fun federation(): FederationResource

    fun ap(): ApResource
    fun app(): AppResource
    fun auth(): AuthResource
    fun accounts(): AccountsResource
    fun users(): UsersResource
    fun lists(): ListsResource
    fun channels(): ChannelsResource
    fun notes(): NotesResource
    fun reactions(): ReactionsResource
    fun favorites(): FavoritesResource
    fun following(): FollowingResource
    fun mutes(): MutesResource
    fun blocks(): BlocksResource
    fun polls(): PollsResource
    fun messages(): MessagesResource
    fun files(): FilesResource
    fun hashtags(): HashtagsResource
    fun other(): OtherResource
    fun webhook(): WebhooksResource
    fun gallery(): GalleriesResource

    /**
     * Get host to access.
     * (ex, misskey.io)
     */
    val host: String

    /**
     * Get authenticate token.
     * (called "i")
     */
    val i: String?
}
