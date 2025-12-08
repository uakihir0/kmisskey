package work.socialhub.kmisskey

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.entity.user.User
import work.socialhub.kmisskey.internal.Internal.fromJson
import java.io.FileReader
import kotlin.test.BeforeTest

open class AbstractTest {

    companion object {
        var HOST: String? = "https://misskey.io/api/"
        var APP_SECRET: String? = System.getenv("MISSKEY_APP_SECRET")
        var USER_TOKEN: String? = System.getenv("MISSKEY_USER_TOKEN")
    }

    fun misskey(): Misskey {
        return MisskeyFactory.instance(
            uri = HOST!!,
            appSecret = APP_SECRET!!,
            userAccessToken = USER_TOKEN!!,
        )
    }

    /**
     * Read File
     */
    private fun readFile(file: String): String? {
        return FileReader(file).readText()
    }

    @BeforeTest
    fun setupTest() {
        try {
            // Get account handle and password.
            val json = readFile("../secrets.json")
            val props = fromJson<Secrets>(json!!)
            val param = props.params[0]

            HOST = param.host
            APP_SECRET = param.appSecret
            USER_TOKEN = param.userToken

        } catch (_: Exception) {
            println("!! secret json file not found. !!")
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
    }

    fun print(user: User) {
        println("=== UserLite ===")
        println("ID       > ${user.id}")
        println("Name     > ${user.name}")
        println("UserName > ${user.username}")
        println("")

        user.asUserDetailedNotMe?.let {
            println("> === UserDetailedNotMe ===")
            println("> FollowingCount > ${it.followingCount}")
            println("> FollowersCount > ${it.followersCount}")
            println("")
        }

        user.asMeDetailed?.let {
            println(">> === MeDetailed ===")
            println(">> UnreadNotificationsCount > ${it.unreadNotificationsCount}")
            println("")
        }
    }
}
