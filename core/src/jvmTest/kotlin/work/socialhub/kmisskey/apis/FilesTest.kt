package work.socialhub.kmisskey.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmisskey.AbstractTest
import work.socialhub.kmisskey.api.request.files.FilesCreateRequest
import kotlin.test.Test

class FilesTest : AbstractTest() {

    @Test
    fun testCreateFile() = runTest {
        val misskey = misskey()
        val stream = javaClass.getResourceAsStream("/icon.png")

        misskey.files().create(
            FilesCreateRequest().also {
                it.bytes = stream.readAllBytes()
                it.name = "icon.png"
                it.force = true
            })
    }
}
