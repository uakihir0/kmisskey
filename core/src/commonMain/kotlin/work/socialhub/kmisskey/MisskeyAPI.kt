package work.socialhub.kmisskey

enum class MisskeyAPI(
     val path: String
) {
    // ------------------------------------------ //
    // Meta
    // ------------------------------------------ //
    Meta("meta"),
    Emojis("emojis"),
    GetOnlineUsersCount("get-online-users-count"),

    // ------------------------------------------ //
    // Announcements
    // ------------------------------------------ //
    Announcements("announcements"),
    ReadAnnouncement("i/read-announcement"),

    // ------------------------------------------ //
    // Federation
    // ------------------------------------------ //
    FederationShowInstance("federation/show-instance"),

    // ------------------------------------------ //
    // Notes
    // ------------------------------------------ //

    NotesCreate("notes/create"),
    NotesDelete("notes/delete"),
    NotesUnrenote("notes/unrenote"),
    NotesRenotes("notes/renotes"),

    Notes("notes"),
    NotesShow("notes/show"),
    UsersNotes("users/notes"),
    NotesSearch("notes/search"),
    NotesReactions("notes/reactions"),
    NotesTimeline("notes/timeline"),
    NotesMentions("notes/mentions"),
    NotesFeatured("notes/featured"),
    NotesLocalTimeline("notes/local-timeline"),
    NotesHybridTimeline("notes/hybrid-timeline"),
    NotesGlobalTimeline("notes/global-timeline"),
    NotesUserListTimeline("notes/user-list-timeline"),

    NotesConversation("notes/conversation"),
    NotesChildren("notes/children"),
    NotesReplies("notes/replies"),

    // ------------------------------------------ //
    // Users
    // ------------------------------------------ //

    UsersFollowers("users/followers"),
    UsersFollowing("users/following"),
    UsersRecommendation("users/recommendation"),

    UsersShow("users/show"),
    UsersReactions("users/reactions"),
    UsersRelation("users/relation"),
    UsersSearch("users/search"),
    UsersSearchByUsernameAndHost("users/search-by-username-and-host"),

    // ------------------------------------------ //
    // I
    // ------------------------------------------ //

    I("i"),
    IFavorites("i/favorites"),
    INotifications("i/notifications"),
    IWebhooksUpdate("i/webhooks/update"),
    IUpdate("i/update"),

    // ------------------------------------------ //
    // Auth
    // ------------------------------------------ //

    AuthSessionGenerate("auth/session/generate"),
    AuthSessionUserkey("auth/session/userkey"),

    // ------------------------------------------ //
    // Ap
    // ------------------------------------------ //

    ApShow("ap/show"),

    // ------------------------------------------ //
    // App
    // ------------------------------------------ //

    AppCreate("app/create"),

    // ------------------------------------------ //
    // Lists
    // ------------------------------------------ //

    Lists("users/lists/list"),
    ListsShow("users/lists/show"),
    ListsPush("users/lists/push"),
    ListsPull("users/lists/pull"),
    ListsCreate("users/lists/create"),
    ListsUpdate("users/lists/update"),
    ListsDelete("users/lists/delete"),

    // ------------------------------------------ //
    // Channels
    // ------------------------------------------ //

    ChannelsOwned("channels/owned"),
    ChannelsMyFavorites("channels/my-favorites"),
    ChannelsFollowed("channels/followed"),
    ChannelsTimeline("channels/timeline"),
    ChannelsShow("channels/show"),

    // ChannelsCreate("channels/create"),
    // ChannelsUnfollow("channels/unfollow"),
    // ChannelsUpdate("channels/update"),
    // ChannelsFavorite("channels/favorite"),
    // ChannelsUnfavorite("channels/unfavorite"),
    // ChannelsFollow("channels/follow"),
    // ChannelsSearch("channels/search"),
    // ChannelsFeatured("channels/featured"),

    // ------------------------------------------ //
    // Antennas
    // ------------------------------------------ //

    // AntennasCreate("antennas/create"),
    // AntennasDelete("antennas/delete"),
    AntennasList("antennas/list"),
    AntennasNotes("antennas/notes"),
    // AntennasShow("antennas/show"),
    // AntennasUpdate("antennas/update"),

    // ------------------------------------------ //
    // Clips
    // ------------------------------------------ //

    ClipsList("clips/list"),
    ClipsNotes("clips/notes"),
    ClipsRemoveNote("clips/remove-note"),
    ClipsAddNote("clips/add-note"),
    ClipsDelete("clips/delete"),
    ClipsCreate("clips/create"),
    ClipsShow("clips/show"),
    ClipsUpdate("clips/update"),

    // ------------------------------------------ //
    // Following
    // ------------------------------------------ //

    FollowingCreate("following/create"),
    FollowingDelete("following/delete"),

    // ------------------------------------------ //
    // Polls
    // ------------------------------------------ //

    PollsVote("notes/polls/vote"),

    // ------------------------------------------ //
    // Messages
    // ------------------------------------------ //

    Messages("messaging/messages"),
    MessagesHistory("messaging/history"),
    MessagesCreate("messaging/messages/create"),
    MessagesDelete("messaging/messages/delete"),

    // ------------------------------------------ //
    // Mutes
    // ------------------------------------------ //

    MutesList("mute/list"),
    MutesCreate("mute/create"),
    MutesDelete("mute/delete"),

    // ------------------------------------------ //
    // Blocks
    // ------------------------------------------ //

    BlocksList("blocking/list"),
    BlocksCreate("blocking/create"),
    BlocksDelete("blocking/delete"),

    // ------------------------------------------ //
    // Favorites
    // ------------------------------------------ //

    FavoritesCreate("notes/favorites/create"),
    FavoritesDelete("notes/favorites/delete"),

    // ------------------------------------------ //
    // Reactions
    // ------------------------------------------ //

    ReactionsCreate("notes/reactions/create"),
    ReactionsDelete("notes/reactions/delete"),

    // ------------------------------------------ //
    // Files
    // ------------------------------------------ //

    FilesCreate("drive/files/create"),

    // ------------------------------------------ //
    // Hashtags
    // ------------------------------------------ //

    HashtagsTrend("hashtags/trend"),

    // ------------------------------------------ //
    // Webhooks
    // ------------------------------------------ //

    IWebhooksShow("i/webhooks/show"),
    IWebhooksList("i/webhooks/list"),
    IWebhooksDelete("i/webhooks/delete"),
    IWebhooksCreate("i/webhooks/create"),

    // ------------------------------------------ //
    // Gallery
    // ------------------------------------------ //

    IGalleryPosts("i/gallery/posts"),
    GalleryPosts("gallery/posts"),
    UserGalleryPosts("users/gallery/posts"),
    ShowGalleryPost("gallery/posts/show"),
    CreateGalleryPost("gallery/posts/create"),
    DeleteGalleryPost("gallery/posts/delete"),
    UpdateGalleryPost("gallery/posts/update"),
    LikeGalleryPost("gallery/posts/like"),
    UnlikeGalleryPost("gallery/posts/unlike"),

    // ------------------------------------------ //
    // Other
    // ------------------------------------------ //

    ServiceWorkerRegister("sw/register"),
    ;
}
