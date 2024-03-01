package misskey4j.apis

import com.google.gson.Gson
import misskey4j.entity.share.Response

class WebhookTest : AbstractTest() {
    var gson: Gson = Gson()

    fun createWebhook(misskey: Misskey): String {
        val on: Array<WebhooksType> = arrayOf<WebhooksType>(WebhooksType.FOLLOW, WebhooksType.NOTE)
        val request: CreateWebhooksRequest = CreateWebhooksRequest.builder()
            .name("WebhookTest")
            .on(on)
            .secret("qazwsx")
            .url("https://socialhub.work/")
            .build()

        val response: Response<CreateWebhooksResponse> = misskey.webhook().create(request)
        System.out.println(gson.toJson(response.get()))
        return response.get().getId()
    }

    fun updateWebhook(misskey: Misskey, webhookId: String?) {
        val on: Array<WebhooksType> =
            arrayOf<WebhooksType>(WebhooksType.FOLLOW, WebhooksType.NOTE, WebhooksType.UNFOLLOW)
        val request: UpdateWebhooksRequest = UpdateWebhooksRequest.builder()
            .webhookId(webhookId)
            .name("WebhookTestRename")
            .secret("qazwsx")
            .url("https://socialhub.work/")
            .active(false)
            .on(on)
            .build()

        val response: Response<UpdateWebhooksResponse> = misskey.webhook().update(request)
        System.out.println(gson.toJson(response.get()))
    }

    fun showWebhook(misskey: Misskey, webhookId: String?): String {
        val request: ShowWebhooksRequest = ShowWebhooksRequest.builder()
            .webhookId(webhookId)
            .build()

        val response: Response<ShowWebhooksResponse> = misskey.webhook().show(request)
        System.out.println(gson.toJson(response.get()))
        return response.get().getId()
    }

    fun listWebhook(misskey: Misskey) {
        val request: ListWebhooksRequest = ListWebhooksRequest.builder().build()
        val response: Response<Array<ShowWebhooksResponse>> = misskey.webhook().list(request)

        for (showWebhooksResponse in response.get()) {
            System.out.println(gson.toJson(showWebhooksResponse))
        }
    }

    fun deleteWebhook(misskey: Misskey, webhookId: String?) {
        val deleteRequest: DeleteWebhooksRequest = DeleteWebhooksRequest.builder()
            .webhookId(webhookId)
            .build()

        val deleteWebhooksResponse: Response<DeleteWebhooksResponse> = misskey.webhook().delete(deleteRequest)
        System.out.println(gson.toJson(deleteWebhooksResponse.get()))
    }

    @Test
    fun testWebhookScenario() {
        val misskey: Misskey =
            MisskeyFactory.getInstance(AbstractTest.HOST, AbstractTest.CLIENT_SECRET, AbstractTest.USER_TOKEN)
        var webhookId = createWebhook(misskey)
        updateWebhook(misskey, webhookId)
        webhookId = showWebhook(misskey, webhookId)
        listWebhook(misskey)
        deleteWebhook(misskey, webhookId)
    }
}
