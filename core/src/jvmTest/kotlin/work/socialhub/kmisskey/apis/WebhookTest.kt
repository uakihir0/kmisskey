package work.socialhub.kmisskey.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmisskey.AbstractTest
import work.socialhub.kmisskey.Misskey
import work.socialhub.kmisskey.api.request.webhooks.CreateWebhooksRequest
import work.socialhub.kmisskey.api.request.webhooks.DeleteWebhooksRequest
import work.socialhub.kmisskey.api.request.webhooks.ListWebhooksRequest
import work.socialhub.kmisskey.api.request.webhooks.ShowWebhooksRequest
import work.socialhub.kmisskey.api.request.webhooks.UpdateWebhooksRequest
import work.socialhub.kmisskey.entity.contant.WebhooksType
import work.socialhub.kmisskey.internal.Internal
import kotlin.test.Test

class WebhookTest : AbstractTest() {

    suspend fun createWebhook(
        misskey: Misskey
    ): String {

        val on = arrayOf(
            WebhooksType.FOLLOW,
            WebhooksType.NOTE
        )
        val request = CreateWebhooksRequest().also { r ->
            r.name = "WebhookTest"
            r.on = on.map { it.name }.toTypedArray()
            r.secret = "qazwsx"
            r.url = "https://socialhub.work/"
        }

        val response = misskey.webhook().create(request)
        println(Internal.toJson(response.data))
        return response.data.id!!
    }

    suspend fun updateWebhook(
        misskey: Misskey,
        webhookId: String
    ) {
        val on = arrayOf(
            WebhooksType.FOLLOW,
            WebhooksType.NOTE,
            WebhooksType.UNFOLLOW
        )
        val request = UpdateWebhooksRequest().also { r ->
            r.name = "WebhookTestRename"
            r.on = on.map { it.name }.toTypedArray()
            r.secret = "qazwsx"
            r.url = "https://socialhub.work/"
            r.webhookId = webhookId
            r.active = false
        }

        val response = misskey.webhook().update(request)
        println(Internal.toJson(response.data))
    }

    suspend fun showWebhook(
        misskey: Misskey,
        webhookId: String,
    ): String {
        val request = ShowWebhooksRequest().also {
            it.webhookId = webhookId
        }

        val response = misskey.webhook().show(request)
        println(Internal.toJson(response.data))
        return response.data.id!!
    }

    suspend fun listWebhook(
        misskey: Misskey
    ) {
        val request = ListWebhooksRequest()
        val response = misskey.webhook().list(request)

        for (showWebhooksResponse in response.data) {
            println(Internal.toJson(showWebhooksResponse))
        }
    }

    suspend fun deleteWebhook(
        misskey: Misskey,
        webhookId: String
    ) {
        val deleteRequest = DeleteWebhooksRequest()
            .also { it.webhookId = webhookId }

        val deleteWebhooksResponse = misskey.webhook().delete(deleteRequest)
        println(Internal.toJson(deleteWebhooksResponse.data))
    }

    @Test
    fun testWebhookScenario() = runTest {

        val misskey = misskey()
        var webhookId = createWebhook(misskey)
        updateWebhook(misskey, webhookId)
        webhookId = showWebhook(misskey, webhookId)
        listWebhook(misskey)
        deleteWebhook(misskey, webhookId)
    }
}
