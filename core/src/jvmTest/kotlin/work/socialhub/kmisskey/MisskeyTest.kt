package work.socialhub.kmisskey

import kotlinx.coroutines.test.runTest
import work.socialhub.kmisskey.api.request.CreateAppRequest
import work.socialhub.kmisskey.api.request.GenerateAuthSessionRequest
import work.socialhub.kmisskey.api.request.GetMiAuthUriRequest
import work.socialhub.kmisskey.api.request.UserKeyAuthSessionRequest
import work.socialhub.kmisskey.api.request.i.IRequest
import work.socialhub.kmisskey.entity.contant.Scope
import kotlin.test.Test

class MisskeyTest : AbstractTest() {

    @Test
    fun testGetMiAuthUri() = runTest {
        val misskey = MisskeyFactory.instance(HOST!!)

        val response = misskey.auth().getMiAuthUri(
            GetMiAuthUriRequest().also { r ->
                r.name = "kmisskey"
                r.callbackUrl = "https://socialhub.work/"
                r.permission = Scope.ALL.map { it.toString() }.toTypedArray()
            }
        )

        println("URL:" + response.data)
    }

    @Test
    fun testCreateApp() = runTest {
        val misskey = MisskeyFactory.instance(HOST!!)

        val response =
            misskey.app().createApp(
                CreateAppRequest().also { r ->
                    r.name = "kmisskey"
                    r.description = "kmisskey"
                    r.callbackUrl = "https://socialhub.work/"
                    r.permission = Scope.ALL.map { it.toString() }.toTypedArray()
                }
            )

        println("ID:" + response.data.id)
        println("Secret:" + response.data.secret)
    }

    @Test
    fun testGenerateSession() = runTest {
        val misskey = MisskeyFactory.instance(HOST!!)

        val generateAuthResponse =
            misskey.auth().sessionGenerate(
                GenerateAuthSessionRequest().also {
                    it.appSecret = APP_SECRET
                }
            )

        println("URL: " + generateAuthResponse.data.url)
    }

    @Test
    fun testUserKey() = runTest {
        val misskey = MisskeyFactory.instance(HOST!!)

        val response =
            misskey.auth().sessionUserKey(
                UserKeyAuthSessionRequest().also {
                    it.token = "VERIFY TOKEN"
                    it.appSecret = APP_SECRET
                }
            )

        println("USER TOKEN: " + response.data.accessToken)
        print(response.data.user!!)
    }

    @Test
    fun testGetI() = runTest {
        val misskey = misskey()
        val response = misskey.accounts().i(IRequest())

        println(response.json)
        print(response.data)
    }

    @Test
    fun testGetIFromWebUIAccessToken() = runTest {
        val misskey = MisskeyFactory.instance(HOST!!, USER_TOKEN!!)
        val response = misskey.accounts().i(IRequest())

        print(response.data)
    }

    @Test
    fun testGetHost() {
        println("NAME: " + misskey().uri)
    }
}
