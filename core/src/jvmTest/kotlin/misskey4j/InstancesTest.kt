package misskey4j

import kotlin.test.Test

class InstancesTest {

    @Test
    fun testGetInstances() {

        val search = MisskeyFactory.searchInstances
        val instances = search.misskeyInstanceList

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
