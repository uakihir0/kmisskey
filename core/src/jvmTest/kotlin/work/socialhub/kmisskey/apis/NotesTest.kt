package work.socialhub.kmisskey.apis

import work.socialhub.kmisskey.AbstractTest
import work.socialhub.kmisskey.api.request.i.IFavoritesRequest
import work.socialhub.kmisskey.api.request.notes.NotesCreateRequest
import work.socialhub.kmisskey.api.request.notes.NotesTimelineRequest
import work.socialhub.kmisskey.entity.Note
import kotlin.test.Test

class NotesTest : AbstractTest() {

    @Test
    fun testTimeline() {
        val misskey = misskey()
        val notes = misskey.notes().timeline(
            NotesTimelineRequest().also {
                it.limit = 100
            })

        println(notes.json + "\n")
        for (note in notes.data) {
            print(note)
        }
    }

    @Test
    fun testFavorites() {
        val misskey = misskey()
        val favorites = misskey.accounts().iFavorites(
            IFavoritesRequest().also {
                it.limit = 100
            })

        println(favorites.json + "\n")
        for (favorite in favorites.data) {
            print(favorite.note)
        }
    }

    @Test
    fun testNotesCreate() {
        val misskey = misskey()
        val response = misskey.notes().create(
            NotesCreateRequest().also {
                it.text = "テスト"
                it.visibility = "home"
            })

        print(response.data.createdNote)
    }

    companion object {
        fun print(note: Note) {

            println("// ------------------------------ //")
            if (note.featuredId != null) {
                println("!!!!!!!Featured!!!!!!!")
            }

            if (note.renote != null) {
                note.renote?.let {
                    println("!!Renote!!")
                    println("User : ${it.user.name}")
                    println("Text : ${it.text}")
                    println("Color: ${it.user.avatarColor}")
                }
            } else {
                println("User : ${note.user.name}")
                println("Text : ${note.text}")
                println("Color: ${note.user.avatarColor}")

                note.user.instance?.let {
                    println("Instance Name : ${it.name}")
                    println("Instance Color: ${it.themeColorObject()}")
                }

                note.files?.forEach {
                    println("File URL          : ${it.url}")
                    println("Extracted File URL: ${it.extractedUrl()}")
                }

                note.emojis?.list?.forEach {
                    println("Emoji Name: ${it.name}")
                    println("Emoji URL : ${it.url}")
                }
            }
        }
    }
}
