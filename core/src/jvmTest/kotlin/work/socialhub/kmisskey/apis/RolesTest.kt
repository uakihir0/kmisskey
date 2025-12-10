package work.socialhub.kmisskey.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmisskey.AbstractTest
import work.socialhub.kmisskey.api.request.roles.RolesRequest
import kotlin.test.Test

class RolesTest : AbstractTest() {

    @Test
    fun testListRoles() = runTest {
        val misskey = misskey()
        val response = misskey.roles().list(RolesRequest())

        println(response.json)
        response.data.forEach {
            println("Role: ${it.name} (ID: ${it.id})")
        }
    }
}
