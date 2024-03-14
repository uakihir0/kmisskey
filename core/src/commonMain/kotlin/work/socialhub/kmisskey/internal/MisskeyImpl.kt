package work.socialhub.kmisskey.internal

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
    override val host: String,
    override val i: String = "",
) : Misskey {

    // No Need AccessToken
    private val meta: MetaResource = MetaResourceImpl(host)
    private val federation: FederationResource = FederationResourceImpl(host)

    // Needs AccessToken
    private val announcements = AnnouncementsResourceImpl(host, i)
    private val ap: ApResource = ApResourceImpl(host, i)
    private val app: AppResource = AppResourceImpl(host)
    private val auth: AuthResource = AuthResourceImpl(host)
    private val accounts: AccountsResource = AccountsResourceImpl(host, i)
    private val users: UsersResource = UsersResourceImpl(host, i)
    private val lists: ListsResource = ListsResourceImpl(host, i)
    private val channels: ChannelsResource = ChannelsResourceImpl(host, i)
    private val antennas: AntennasResource = AntennasResourceImpl(host, i)
    private val clips: ClipsResource = ClipsResourceImpl(host, i)
    private val notes: NotesResource = NotesResourceImpl(host, i)
    private val mutes: MutesResource = MutesResourceImpl(host, i)
    private val blocks: BlocksResource = BlocksResourceImpl(host, i)
    private val reactions: ReactionsResource = ReactionsResourceImpl(host, i)
    private val favorites: FavoritesResource = FavoritesResourceImpl(host, i)
    private val following: FollowingResource = FollowingResourceImpl(host, i)
    private val polls: PollsResource = PollsResourceImpl(host, i)
    private val messages: MessagesResource = MessagesResourceImpl(host, i)
    private val files: FilesResource = FilesResourceImpl(host, i)
    private val hashtags: HashtagsResource = HashtagsResourceImpl(host, i)
    private val webhooks: WebhooksResource = WebhooksResourceImpl(host, i)
    private val galleries: GalleriesResource = GalleriesResourceImpl(host, i)
    private val other: OtherResource = OtherResourceImpl(host, i)

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
}
