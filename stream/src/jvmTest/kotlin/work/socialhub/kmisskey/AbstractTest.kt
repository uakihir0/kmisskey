package work.socialhub.kmisskey

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.internal.Internal
import java.io.FileReader
import kotlin.test.BeforeTest

open class AbstractTest {

    companion object {
        var HOST: String? = "https://misskey.io/api/"
        var APP_SECRET: String? = null
        var USER_TOKEN: String? = null
        var OWNED_USER_TOKEN: String? = null
    }

    fun misskey(): Misskey {
        return MisskeyFactory.instance(
            HOST!!, APP_SECRET!!, USER_TOKEN!!
        )
    }

    /**
     * Read File
     */
    private fun readFile(file: String): String {
        return FileReader(file).readText()
    }

    @BeforeTest
    fun setupTest() {
        try {
            // Get account handle and password.
            val json = readFile("../secrets.json")
            val props = Internal.fromJson<Secrets>(json)
            val param = props.params[0]

            HOST = param.host
            APP_SECRET = param.appSecret
            USER_TOKEN = param.userToken
            OWNED_USER_TOKEN = param.ownedUserToken

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    @Serializable
    class Secrets {
        var params: List<SecretParams> = listOf()
    }

    @Serializable
    class SecretParams {
        var host: String? = null

        @SerialName("app_secret")
        var appSecret: String? = null

        @SerialName("user_token")
        var userToken: String? = null

        @SerialName("owned_user_token")
        var ownedUserToken: String? = null
    }
}