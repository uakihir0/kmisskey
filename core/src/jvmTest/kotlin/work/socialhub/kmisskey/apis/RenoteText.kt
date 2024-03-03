package work.socialhub.kmisskey.apis

import work.socialhub.kmisskey.AbstractTest
import work.socialhub.kmisskey.api.request.notes.NotesCreateRequest
import kotlin.test.Test

class RenoteText : AbstractTest() {

    @Test
    fun testRenote() {
        val misskey = misskey()

        misskey.notes().create(
            NotesCreateRequest().also {
                it.renoteId = ""
                it.visibility = "home"
                it.text = "テスト"
            })
    }
}
