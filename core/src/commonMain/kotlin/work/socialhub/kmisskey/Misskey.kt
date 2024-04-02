package work.socialhub.kmisskey

import work.socialhub.kmisskey.api.AccountsResource
import work.socialhub.kmisskey.api.AnnouncementsResource
import work.socialhub.kmisskey.api.AntennasResource
import work.socialhub.kmisskey.api.ApResource
import work.socialhub.kmisskey.api.AppResource
import work.socialhub.kmisskey.api.AuthResource
import work.socialhub.kmisskey.api.BlocksResource
import work.socialhub.kmisskey.api.ChannelsResource
import work.socialhub.kmisskey.api.ClipsResource
import work.socialhub.kmisskey.api.FavoritesResource
import work.socialhub.kmisskey.api.FederationResource
import work.socialhub.kmisskey.api.FilesResource
import work.socialhub.kmisskey.api.FollowingResource
import work.socialhub.kmisskey.api.GalleriesResource
import work.socialhub.kmisskey.api.HashtagsResource
import work.socialhub.kmisskey.api.ListsResource
import work.socialhub.kmisskey.api.MessagesResource
import work.socialhub.kmisskey.api.MetaResource
import work.socialhub.kmisskey.api.MutesResource
import work.socialhub.kmisskey.api.NotesResource
import work.socialhub.kmisskey.api.OtherResource
import work.socialhub.kmisskey.api.PollsResource
import work.socialhub.kmisskey.api.ReactionsResource
import work.socialhub.kmisskey.api.UsersResource
import work.socialhub.kmisskey.api.WebhooksResource
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
    fun antennas(): AntennasResource
    fun clips(): ClipsResource
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
     * Get uri to access.
     * (ex, https://misskey.io/api)
     */
    val uri: String

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
