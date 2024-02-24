package misskey4j.internal

import misskey4j.Misskey
import misskey4j.api.*
import misskey4j.internal.api.*

class MisskeyImpl(
    override val host: String,
    override val i: String = "",
) : Misskey {

    // No Need AccessToken
    private val meta: MetaResource = MetaResourceImpl(host)
    private val federation: FederationResource = FederationResourceImpl(host)

    // Needs AccessToken
    private val ap: ApResource = ApResourceImpl(host, i)
    private val app: AppResource = AppResourceImpl(host)
    private val auth: AuthResource = AuthResourceImpl(host)
    private val accounts: AccountsResource = AccountsResourceImpl(host, i)
    private val users: UsersResource = UsersResourceImpl(host, i)
    private val lists: ListsResource = ListsResourceImpl(host, i)
    private val channels: ChannelsResource = ChannelsResourceImpl(host, i)
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

    override fun ap() = ap
    override fun app() = app
    override fun auth() = auth
    override fun accounts() = accounts
    override fun users() = users
    override fun lists() = lists
    override fun channels() = channels
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
