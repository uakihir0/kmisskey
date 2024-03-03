package work.socialhub.kmisskey.apis

import work.socialhub.kmisskey.AbstractTest
import work.socialhub.kmisskey.api.request.meta.EmojisRequest
import work.socialhub.kmisskey.api.request.meta.MetaRequest
import kotlin.test.Test

class MetaTest : AbstractTest() {

    @Test
    fun testGetMeta() {
        val misskey = misskey()
        misskey.meta().meta(MetaRequest().also {
            it.detail = true
        })
    }

    @Test
    fun testGetEmojis() {
        val misskey = misskey()
        val response = misskey.meta().emojis(EmojisRequest())

        response.data.emojis.forEach {
            println(it.name)
            println(it.url)
        }
    }
}
