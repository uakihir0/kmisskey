package misskey4j.apis

import misskey4j.AbstractTest
import misskey4j.api.request.notes.NotesCreateRequest
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
