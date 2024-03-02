package misskey4j.apis

import misskey4j.AbstractTest
import misskey4j.Misskey
import misskey4j.api.request.webhooks.*
import misskey4j.entity.contant.WebhooksType
import misskey4j.internal.Internal
import kotlin.test.Test

class WebhookTest : AbstractTest() {

    fun createWebhook(
        misskey: Misskey
    ): String {

        val on = arrayOf(
            WebhooksType.FOLLOW,
            WebhooksType.NOTE
        )
        val request = CreateWebhooksRequest().also { r ->
            r.name = "WebhookTest"
            r.on = on.map { it.name }
            r.secret = "qazwsx"
            r.url = "https://socialhub.work/"
        }

        val response = misskey.webhook().create(request)
        println(Internal.toJson(response.data))
        return response.data.id!!
    }

    fun updateWebhook(
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
            r.on = on.map { it.name }
            r.secret = "qazwsx"
            r.url = "https://socialhub.work/"
            r.webhookId = webhookId
            r.active = false
        }

        val response = misskey.webhook().update(request)
        println(Internal.toJson(response.data))
    }

    fun showWebhook(
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

    fun listWebhook(
        misskey: Misskey
    ) {
        val request = ListWebhooksRequest()
        val response = misskey.webhook().list(request)

        for (showWebhooksResponse in response.data) {
            println(Internal.toJson(showWebhooksResponse))
        }
    }

    fun deleteWebhook(
        misskey: Misskey,
        webhookId: String
    ) {
        val deleteRequest = DeleteWebhooksRequest().also { r ->
            r.webhookId = webhookId
        }
        val deleteWebhooksResponse = misskey.webhook().delete(deleteRequest)
        println(Internal.toJson(deleteWebhooksResponse.data))
    }

    @Test
    fun testWebhookScenario() {

        val misskey = misskey()
        var webhookId = createWebhook(misskey)
        updateWebhook(misskey, webhookId)
        webhookId = showWebhook(misskey, webhookId)
        listWebhook(misskey)
        deleteWebhook(misskey, webhookId)
    }
}
