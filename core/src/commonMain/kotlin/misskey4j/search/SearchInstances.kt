package misskey4j.search

import com.google.gson.Gson
import misskey4j.entity.search.JoinInstance
import misskey4j.internal.util.MediaType
import work.socialhub.khttpclient.HttpRequest

/**
 * Get Instance lists.
 */
class SearchInstances(
    val apiPath: String,
) {
    val misskeyInstanceList: JoinInstance.Instances
        get() {
            try {
                val response = HttpRequest()
                    .url(apiPath)
                    .accept(MediaType.JSON)
                    .get()

                val gson: Gson = AbstractResourceImpl.getGsonInstance()
                val results: JoinInstance.Instances =
                    gson.fromJson(response.asString(), JoinInstance.Instances::class.java)

                results.instances!!.forEach(java.util.function.Consumer<JoinInstance> { instance: JoinInstance ->
                    val desc: String = instance.description
                    if (desc != null && !desc.isEmpty()) {
                        instance.description = desc
                            .replace("\\<.*?\\>".toRegex(), "")
                            .replace("\n".toRegex(), "")
                    }
                })
                return results

            } catch (e: Exception) {
                throw MisskeyException(e)
            }
        }
}
