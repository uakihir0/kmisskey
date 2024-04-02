package work.socialhub.kmisskey.internal

import io.ktor.http.*
import work.socialhub.kmisskey.Misskey
import work.socialhub.kmisskey.api.AccountsResource
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
import work.socialhub.kmisskey.internal.api.AccountsResourceImpl
import work.socialhub.kmisskey.internal.api.AnnouncementsResourceImpl
import work.socialhub.kmisskey.internal.api.AntennasResourceImpl
import work.socialhub.kmisskey.internal.api.ApResourceImpl
import work.socialhub.kmisskey.internal.api.AppResourceImpl
import work.socialhub.kmisskey.internal.api.AuthResourceImpl
import work.socialhub.kmisskey.internal.api.BlocksResourceImpl
import work.socialhub.kmisskey.internal.api.ChannelsResourceImpl
import work.socialhub.kmisskey.internal.api.ClipsResourceImpl
import work.socialhub.kmisskey.internal.api.FavoritesResourceImpl
import work.socialhub.kmisskey.internal.api.FederationResourceImpl
import work.socialhub.kmisskey.internal.api.FilesResourceImpl
import work.socialhub.kmisskey.internal.api.FollowingResourceImpl
import work.socialhub.kmisskey.internal.api.GalleriesResourceImpl
import work.socialhub.kmisskey.internal.api.HashtagsResourceImpl
import work.socialhub.kmisskey.internal.api.ListsResourceImpl
import work.socialhub.kmisskey.internal.api.MessagesResourceImpl
import work.socialhub.kmisskey.internal.api.MetaResourceImpl
import work.socialhub.kmisskey.internal.api.MutesResourceImpl
import work.socialhub.kmisskey.internal.api.NotesResourceImpl
import work.socialhub.kmisskey.internal.api.OtherResourceImpl
import work.socialhub.kmisskey.internal.api.PollsResourceImpl
import work.socialhub.kmisskey.internal.api.ReactionsResourceImpl
import work.socialhub.kmisskey.internal.api.UsersResourceImpl
import work.socialhub.kmisskey.internal.api.WebhooksResourceImpl


class MisskeyImpl(
    override val uri: String,
    override val i: String = "",
) : Misskey {

    // No Need AccessToken
    private val meta: MetaResource = MetaResourceImpl(uri)
    private val federation: FederationResource = FederationResourceImpl(uri)

    // Needs AccessToken
    private val announcements = AnnouncementsResourceImpl(uri, i)
    private val ap: ApResource = ApResourceImpl(uri, i)
    private val app: AppResource = AppResourceImpl(uri)
    private val auth: AuthResource = AuthResourceImpl(uri)
    private val accounts: AccountsResource = AccountsResourceImpl(uri, i)
    private val users: UsersResource = UsersResourceImpl(uri, i)
    private val lists: ListsResource = ListsResourceImpl(uri, i)
    private val channels: ChannelsResource = ChannelsResourceImpl(uri, i)
    private val antennas: AntennasResource = AntennasResourceImpl(uri, i)
    private val clips: ClipsResource = ClipsResourceImpl(uri, i)
    private val notes: NotesResource = NotesResourceImpl(uri, i)
    private val mutes: MutesResource = MutesResourceImpl(uri, i)
    private val blocks: BlocksResource = BlocksResourceImpl(uri, i)
    private val reactions: ReactionsResource = ReactionsResourceImpl(uri, i)
    private val favorites: FavoritesResource = FavoritesResourceImpl(uri, i)
    private val following: FollowingResource = FollowingResourceImpl(uri, i)
    private val polls: PollsResource = PollsResourceImpl(uri, i)
    private val messages: MessagesResource = MessagesResourceImpl(uri, i)
    private val files: FilesResource = FilesResourceImpl(uri, i)
    private val hashtags: HashtagsResource = HashtagsResourceImpl(uri, i)
    private val webhooks: WebhooksResource = WebhooksResourceImpl(uri, i)
    private val galleries: GalleriesResource = GalleriesResourceImpl(uri, i)
    private val other: OtherResource = OtherResourceImpl(uri, i)

    override fun meta() = meta
    override fun federation() = federation

    override fun announcements() = announcements
    override fun ap() = ap
    override fun app() = app
    override fun auth() = auth
    override fun accounts() = accounts
    override fun users() = users
    override fun lists() = lists
    override fun channels() = channels
    override fun antennas() = antennas
    override fun clips() = clips
    override fun notes() = notes
    override fun reactions() = reactions
    override fun favorites() = favorites
    override fun following() = following
    override fun mutes() = mutes
    override fun blocks() = blocks
    override fun polls() = polls
    override fun messages() = messages
    override fun files() = files
    override fun hashtags() = hashtags
    override fun other() = other
    override fun webhook() = webhooks
    override fun gallery() = galleries

    override val host: String
        get() = Url(uri).host
}
