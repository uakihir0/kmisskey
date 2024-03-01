package misskey4j.apis

import misskey4j.AbstractTest
import misskey4j.api.request.meta.EmojisRequest
import misskey4j.api.request.meta.MetaRequest
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

        response.data.emojis.forEach { e ->
            println(e.name)
            println(e.url)
        }
    }
}
