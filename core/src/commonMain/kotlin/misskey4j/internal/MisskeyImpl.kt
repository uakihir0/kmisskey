package misskey4j.internal

import misskey4j.Misskey
import misskey4j.api.*

class MisskeyImpl(
    val url: String,
    val authToken: String,
) : Misskey {
    private val meta: MetaResource
    private val federation: FederationResource
    private val ap: ApResource
    private val app: AppResource
    private val auth: AuthResource
    private val accounts: AccountsResource
    private val users: UsersResource
    private val lists: ListsResource
    private val channels: ChannelsResource
    private val notes: NotesResource
    private val mutes: MutesResource
    private val blocks: BlocksResource
    private val reactions: ReactionsResource
    private val favorites: FavoritesResource
    private val following: FollowingResource
    private val polls: PollsResource
    private val messages: MessagesResource
    private val files: FilesResource
    private val hashtags: HashtagsResource
    private val webhooks: WebhooksResource
    private val galleries: GalleriesResource
    private val other: OtherResource

    init {
        meta = MetaResourceImpl(url)
        federation = FederationResourceImpl(url)
        app = AppResourceImpl(url)
        auth = AuthResourceImpl(url)

        // Needs AccessToken
        ap = ApResourceImpl(url, authToken)
        accounts = AccountsResourceImpl(url, authToken)
        users = UsersResourceImpl(url, authToken)
        lists = ListsResourceImpl(url, authToken)
        channels = ChannelsResourceImpl(url, authToken)
        notes = NotesResourceImpl(url, authToken)

        reactions = ReactionsResourceImpl(url, authToken)
        favorites = FavoritesResourceImpl(url, authToken)
        following = FollowingResourceImpl(url, authToken)
        mutes = MutesResourceImpl(url, authToken)
        blocks = BlocksResourceImpl(url, authToken)
        polls = PollsResourceImpl(url, authToken)
        messages = MessagesResourceImpl(url, authToken)
        files = FilesResourceImpl(url, authToken)
        hashtags = HashtagsResourceImpl(url, authToken)
        webhooks = WebhooksResourceImpl(url, authToken)
        galleries = GalleriesResourceImpl(url, authToken)
        other = OtherResourceImpl(url, authToken)
    }

    fun meta(): MetaResource {
        return meta
    }

    fun federation(): FederationResource {
        return federation
    }

    fun ap(): ApResource {
        return ap
    }

    fun app(): AppResource {
        return app
    }

    fun auth(): AuthResource {
        return auth
    }

    fun accounts(): AccountsResource {
        return accounts
    }

    fun users(): UsersResource {
        return users
    }

    fun lists(): ListsResource {
        return lists
    }

    fun channels(): ChannelsResource {
        return channels
    }

    fun notes(): NotesResource {
        return notes
    }

    fun reactions(): ReactionsResource {
        return reactions
    }

    fun favorites(): FavoritesResource {
        return favorites
    }

    fun following(): FollowingResource {
        return following
    }

    fun mutes(): MutesResource {
        return mutes
    }

    fun blocks(): BlocksResource {
        return blocks
    }

    fun polls(): PollsResource {
        return polls
    }

    fun messages(): MessagesResource {
        return messages
    }

    fun files(): FilesResource {
        return files
    }

    fun hashtags(): HashtagsResource {
        return hashtags
    }

    fun other(): OtherResource {
        return other
    }

    fun webhook(): WebhooksResource {
        return webhooks
    }

    fun gallery(): GalleriesResource {
        return galleries
    }


    val host: String
        /**
         * {@inheritDoc}
         */
        get() {
            try {
                return java.net.URL(url).getHost()
            } catch (e: Throwable) {
                throw java.lang.IllegalStateException(e)
            }
        }

    /**
     * {@inheritDoc}
     */
    fun stream(): MisskeyStream {
        return MisskeyStream(this)
    }
}
