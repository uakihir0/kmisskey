package misskey4j

import misskey4j.api.request.CreateAppRequest
import misskey4j.api.request.GenerateAuthSessionRequest
import misskey4j.api.request.GetMiAuthUriRequest
import misskey4j.api.request.UserKeyAuthSessionRequest
import misskey4j.api.request.i.IRequest
import misskey4j.entity.contant.Scope
import kotlin.test.Test

class MisskeyTest : AbstractTest() {

    @Test
    fun testGetMiAuthUri() {
        val misskey = MisskeyFactory.instance(HOST!!)

        val response = misskey.auth().getMiAuthUri(
            GetMiAuthUriRequest().also { r ->
                r.name = "kmisskey"
                r.callbackUrl = "https://socialhub.work/"
                r.permission = Scope.ALL.map { it.target }
            }
        )

        println("URL:" + response.data)
    }

    @Test
    fun testCreateApp() {
        val misskey = MisskeyFactory.instance(HOST!!)

        val response =
            misskey.app().createApp(
                CreateAppRequest().also { r ->
                    r.name = "kmisskey"
                    r.description = "kmisskey"
                    r.callbackUrl = "https://socialhub.work/"
                    r.permission = Scope.ALL.map { it.target }
                }
            )

        println("ID:" + response.data.id)
        println("Secret:" + response.data.secret)
    }

    @Test
    fun testGenerateSession() {
        val misskey = MisskeyFactory.instance(HOST!!)

        val createAppResponse =
            misskey.app().createApp(
                CreateAppRequest().also { r ->
                    r.name = "kmisskey"
                    r.description = "kmisskey"
                    r.callbackUrl = "https://socialhub.work/"
                    r.permission = Scope.ALL.map { it.target }
                }
            )

        val generateAuthResponse =
            misskey.auth().sessionGenerate(
                GenerateAuthSessionRequest().also {
                    it.appSecret = createAppResponse.data.secret
                }
            )

        println("URL: " + generateAuthResponse.data.url)
    }

    @Test
    fun testUserKey() {
        val misskey = MisskeyFactory.instance(HOST!!)

        val response =
            misskey.auth().sessionUserKey(
                UserKeyAuthSessionRequest().also {
                    it.token = "VERIFY TOKEN"
                    it.appSecret = CLIENT_SECRET
                }
            )

        println("USER TOKEN: " + response.data.accessToken)
        println("NAME: " + response.data.user!!.name)
    }

    @Test
    fun testGetI() {
        val misskey = misskey()
        val response = misskey.accounts().i(IRequest(misskey.i!!))

        println("NAME: " + response.data.name)
    }

    @Test
    fun testGetIFromWebUIAccessToken() {
        val misskey = MisskeyFactory.instance(HOST!!, OWNED_USER_TOKEN!!)
        val response = misskey.accounts().i(IRequest(misskey.i!!))

        println("NAME: " + response.data.name)
    }

    @Test
    fun testGetHost() {
        println("NAME: " + misskey().host)
    }
}
