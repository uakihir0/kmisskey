package work.socialhub.kmisskey.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmisskey.AbstractTest
import work.socialhub.kmisskey.api.request.pages.PagesCreateRequest
import work.socialhub.kmisskey.entity.PageContent
import work.socialhub.kmisskey.entity.PageVariable
import kotlin.test.Test

class PagesTest : AbstractTest() {

    @Test
    fun testCreatePage() = runTest {
        try {
            val misskey = misskey()
            val request = PagesCreateRequest()
            request.title = "Test Page"
            request.name = "test_page_" + System.currentTimeMillis()
            request.summary = "This is a test page."
            
            request.content = arrayOf(
                PageContent().also {
                    it.type = "text"
                    it.text = "Hello World"
                }
            )
            request.variables = emptyArray()
            request.script = "console.log('Hello');"

            val response = misskey.pages().create(request)
            println(response.json)
            println("Created Page: ${response.data.title} ID: ${response.data.id}")
        } catch (e: Exception) {
            println("Error: " + e.message)
            throw e
        }
    }
}
