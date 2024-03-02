package misskey4j.apis

import misskey4j.AbstractTest
import misskey4j.api.request.files.FilesCreateRequest
import kotlin.test.Test

class FilesTest : AbstractTest() {

    @Test
    fun testCreateFile() {
        val misskey = misskey()
        val stream = javaClass.getResourceAsStream("/img/misskey4j.png")

        misskey.files().create(
            FilesCreateRequest().also {
                it.bytes = stream.readAllBytes()
                it.name = "misskey4j.png"
                it.force = true
            })
    }
}
