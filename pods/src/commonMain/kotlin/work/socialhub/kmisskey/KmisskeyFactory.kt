package work.socialhub.kmisskey

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlin.js.JsName

@OptIn(ExperimentalJsExport::class)
@JsExport
class KmisskeyFactory {

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