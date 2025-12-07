package work.socialhub.kmisskey.search

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmisskey.entity.search.JoinInstance
import work.socialhub.kmisskey.internal.Internal
import work.socialhub.kmisskey.internal.util.MediaType
import work.socialhub.kmisskey.util.toBlocking

/**
 * Get Instance lists.
 */
class SearchInstances(
    val path: String,
) {
    suspend fun getInstances(): JoinInstance.Instances {

        val response = HttpRequest()
            .url(path)
            .accept(MediaType.JSON)
            .get()

        val results: JoinInstance.Instances =
            Internal.fromJson(response.stringBody)

        return results.also {
            it.instances!!.forEach { instance ->
                val desc = instance.description
                if (!desc.isNullOrEmpty()) {
                    instance.description = desc
                        .replace("<.*?>".toRegex(), "")
                        .replace("\n".toRegex(), "")
                }
            }
        }
    }

    fun getInstancesBlocking(): JoinInstance.Instances {
        return toBlocking {
            getInstances()
        }
    }
}
