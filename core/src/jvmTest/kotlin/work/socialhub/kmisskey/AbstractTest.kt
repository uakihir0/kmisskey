package work.socialhub.kmisskey

import kotlinx.serialization.json.Json
import work.socialhub.kmisskey.entity.user.User
import java.io.File
import kotlin.test.BeforeTest

open class AbstractTest {

    companion object {
        var HOST: String? = "https://misskey.io/api/"
        var APP_SECRET: String? = null
        var USER_TOKEN: String? = null
    }

    protected val json = Json {
        ignoreUnknownKeys = true
    }

    fun misskey(): Misskey {
        return MisskeyFactory.instance(
            uri = HOST!!,
            appSecret = APP_SECRET!!,
            userAccessToken = USER_TOKEN!!,
        )
    }

    @BeforeTest
    fun setupTest() {

        try {
            // Get credentials from environment variables.
            HOST = System.getenv("MISSKEY_HOST")
                ?: System.getProperty("MISSKEY_HOST")
                ?: HOST
            APP_SECRET = System.getenv("MISSKEY_APP_SECRET")
                ?: System.getProperty("MISSKEY_APP_SECRET")
            USER_TOKEN = System.getenv("MISSKEY_USER_TOKEN")
                ?: System.getProperty("MISSKEY_USER_TOKEN")
        } catch (_: Exception) {
        }

        if (APP_SECRET == null || USER_TOKEN == null) {
            try {
                // Get credentials from secrets.json file.
                readTestProps()?.get("misskey")?.let {
                    HOST = it["MISSKEY_HOST"] ?: HOST
                    APP_SECRET = it["MISSKEY_APP_SECRET"]
                    USER_TOKEN = it["MISSKEY_USER_TOKEN"]
                }
            } catch (_: Exception) {
            }
        }

        if (APP_SECRET == null || USER_TOKEN == null) {
            throw IllegalStateException(
                """!!!
                No credentials exist for testing.
                Set the environment variables MISSKEY_APP_SECRET and MISSKEY_USER_TOKEN
                or copy the following file and describe its contents.
                `cp secrets.json.default secrets.json`
                !!!""".trimIndent()
            )
        }
    }

    /**
     * Read Test Properties
     */
    private fun readTestProps(): Map<String, Map<String, String>>? {
        return try {
            val jsonStr = File("../secrets.json").readText()
            json.decodeFromString<Map<String, Map<String, String>>>(jsonStr)
        } catch (e: Exception) {
            null
        }
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
