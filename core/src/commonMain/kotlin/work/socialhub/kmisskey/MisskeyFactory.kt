package work.socialhub.kmisskey

import io.ktor.utils.io.core.*
import org.kotlincrypto.hash.sha2.SHA256
import work.socialhub.kmisskey.internal.MisskeyImpl
import work.socialhub.kmisskey.search.SearchInstances

@OptIn(ExperimentalStdlibApi::class)
object MisskeyFactory {

    fun instance(uri: String): Misskey {
        return MisskeyImpl(absorbUrlExpression(uri), "")
    }

    /**
     * Used for user access by specifying the application.
     * アプリケーションを発行して、第三者の AccessToken を使用する場合に用います。
     */
    fun instance(
        uri: String,
        clientSecret: String,
        userAccessToken: String,
    ): Misskey {
        val str = (userAccessToken + clientSecret)
        val result = SHA256().digest(str.toByteArray())

        var hex = result.toHexString()
        while (hex.length < 40) {
            hex = "0$hex"
        }

        return MisskeyImpl(
            absorbUrlExpression(uri),
            hex,
        )
    }

    /**
     * Create an instance using the AccessToken obtained from the Web UI.
     * Web UI で発行した自身の AccessToken を使用する場合に用います。
     */
    fun instance(
        uri: String,
        ownedAccessToken: String
    ): Misskey {
        return MisskeyImpl(
            absorbUrlExpression(uri),
            ownedAccessToken,
        )
    }

    val searchInstances: SearchInstances
        get() = SearchInstances("https://instanceapp.misskey.page/instances.json")

    private fun absorbUrlExpression(
        url: String,
    ): String {
        var result = url

        // ホスト名だけで指定してきた場合
        if (!result.startsWith("https://")) {
            result = "https://$result"
        }
        // API ディレクトリが抜けていた場合
        if (!result.endsWith("/api/")) {
            result = "$result/api/"
        }
        if (!result.endsWith("api/")) {
            result = "${result}api/"
        }
        return result
    }
}
