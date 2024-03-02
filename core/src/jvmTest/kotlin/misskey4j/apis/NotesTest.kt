package misskey4j.apis

import misskey4j.AbstractTest
import misskey4j.api.request.i.IFavoritesRequest
import misskey4j.api.request.notes.NotesTimelineRequest
import misskey4j.entity.Color
import misskey4j.entity.File
import misskey4j.entity.Note
import kotlin.test.Test

class NotesTest : AbstractTest() {

    @Test
    fun testTimeline() {
        val misskey = misskey()
        val notes = misskey.notes().timeline(
            NotesTimelineRequest().also {
                it.limit = 100L
            })

        for (note in notes.data) {
            print(note)
        }
    }

    @Test
    fun testFavorites() {
        val misskey = misskey()
        val favorites = misskey.accounts().iFavorites(
            IFavoritesRequest().also {
                it.limit = 100L
            })

        for (favorite in favorites.data) {
            print(favorite.note)
        }
    }


    companion object {
        fun print(note: Note) {
            println("// ------------------------------ //")
            if (note.featuredId != null) {
                println("!!!!!!!Featured!!!!!!!")
            }

            if (note.renote != null) {
                println("!!Renote!!")
                println("User: " + note.renote!!.user.name)
                println("Text: " + note.renote!!.text)
                printColor(note.renote!!.user.avatarColor)
            } else {
                println("User: " + note.user.name)
                println("Text: " + note.text)
                printColor(note.user.avatarColor)

                if (note.user.instance != null) {
                    val instance = note.user.instance
                    println("Instance Name: " + instance!!.name)
                    println("Instance Color R: " + instance.themeColor!!.r)
                }

                note.files?.forEach { e: File ->
                    println("File OriginalURL: " + e.originalUrl)
                    println("File URL: " + e.url())
                }

                note.emojis?.list?.forEach { e ->
                    println("Emoji Name: " + e.name)
                    println("Emoji URL: " + e.url)
                }
            }
        }

        private fun printColor(color: Color?) {
            if (color != null) {
                println(
                    "Color: " + color.r
                            + "," + color.g
                            + "," + color.b
                )
            } else {
                println("Color: null")
            }
        }
    }
}
