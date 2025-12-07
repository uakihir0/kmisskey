package work.socialhub.kmisskey.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmisskey.AbstractTest
import work.socialhub.kmisskey.api.request.notes.NotesCreateRequest
import kotlin.test.Test

class RenoteText : AbstractTest() {

    @Test
    fun testRenote() = runTest {
        val misskey = misskey()

        misskey.notes().create(
            NotesCreateRequest().also {
                it.renoteId = ""
                it.visibility = "home"
                it.text = "テスト"
            })
    }
}
