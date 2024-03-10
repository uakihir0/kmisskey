package work.socialhub.kmisskey

class KmisskeyFactory {

    fun instance(
        uri: String,
    ) = MisskeyFactory
        .instance(uri)

    fun instance(
        uri: String,
        userAccessToken: String,
    ) = MisskeyFactory
        .instance(uri, userAccessToken)

    fun instance(
        uri: String,
        clientSecret: String,
        userAccessToken: String,
    ) = MisskeyFactory
        .instance(uri, clientSecret, userAccessToken)
}