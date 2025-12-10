package work.socialhub.kmisskey.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmisskey.AbstractTest
import work.socialhub.kmisskey.api.request.folders.FoldersRequest
import work.socialhub.kmisskey.api.request.folders.FoldersCreateRequest
import kotlin.test.Test

class FoldersTest : AbstractTest() {

    @Test
    fun testListFolders() = runTest {
        val misskey = misskey()
        val response = misskey.folders().list(FoldersRequest())

        println(response.json)
        response.data.forEach {
            println("Folder: ${it.name}")
        }
    }
    
    @Test
    fun testCreateFolder() = runTest {
        val misskey = misskey()
        val request = FoldersCreateRequest()
        request.name = "TestFolder"
        
        val response = misskey.folders().create(request)
        println(response.json)
        println("Created Folder: ${response.data.name} ID: ${response.data.id}")
    }
}
