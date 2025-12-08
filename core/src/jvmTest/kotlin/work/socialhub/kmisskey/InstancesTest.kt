package work.socialhub.kmisskey

import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class InstancesTest {

    @Test
    fun testGetInstances() = runTest {

        val search = MisskeyFactory.searchInstances
        val instances = search.getInstances()

        for (joinInstance in instances.instances!!) {
            println("======================================")
            println("URL    > " + joinInstance.url)
            println("DESC   > " + joinInstance.description)

            joinInstance.meta?.let { meta ->
                println("S BANNER > " + meta.bannerUrl)
                println("O BANNER > " + meta.bannerUrl)
            }

            joinInstance.stats?.let { stats ->
                println("NOTES COUNT > " + stats.originalNotesCount)
                println("USERS COUNT > " + stats.originalUsersCount)
            }
        }
    }
}
