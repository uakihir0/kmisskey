package work.socialhub.kmisskey

import work.socialhub.kmisskey.api.request.CreateAppRequest
import work.socialhub.kmisskey.api.request.GenerateAuthSessionRequest
import work.socialhub.kmisskey.api.request.GetMiAuthUriRequest
import work.socialhub.kmisskey.api.request.UserKeyAuthSessionRequest
import work.socialhub.kmisskey.api.request.i.IRequest
import work.socialhub.kmisskey.entity.contant.Scope
import kotlin.test.Test

class MisskeyTest : AbstractTest() {

    @Test
    fun testGetMiAuthUri() {
        val misskey = MisskeyFactory.instance(HOST!!)

        val response = misskey.auth().getMiAuthUri(
            GetMiAuthUriRequest().also { r ->
                r.name = "kmisskey"
                r.callbackUrl = "https://socialhub.work/"
                r.permission = Scope.ALL.map { it.target }.toTypedArray()
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
                    r.permission = Scope.ALL.map { it.target }.toTypedArray()
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
                    r.permission = Scope.ALL.map { it.target }.toTypedArray()
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
        print(response.data.user!!)
    }

    @Test
    fun testGetI() {
        val misskey = misskey()
        val response = misskey.accounts().i(IRequest())

        println(response.json)
        print(response.data)
    }

    @Test
    fun testGetIFromWebUIAccessToken() {
        val misskey = MisskeyFactory.instance(HOST!!, OWNED_USER_TOKEN!!)
        val response = misskey.accounts().i(IRequest())

        print(response.data)
    }

    @Test
    fun testGetHost() {
        println("NAME: " + misskey().host)
    }
}
