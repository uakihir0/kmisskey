package work.socialhub.kmisskey

import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
object KmisskeyFactory {

    fun instance(
        uri: String,
    ) = MisskeyFactory
        .instance(uri)

    @JsName("instanceOwnedAccessToken")
    fun instance(
        uri: String,
        userAccessToken: String,
    ) = MisskeyFactory
        .instance(uri, userAccessToken)

    @JsName("instanceUserAccessToken")
    fun instance(
        uri: String,
        clientSecret: String,
        userAccessToken: String,
    ) = MisskeyFactory
        .instance(uri, clientSecret, userAccessToken)
}