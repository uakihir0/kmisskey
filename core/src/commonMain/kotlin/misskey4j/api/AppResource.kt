package misskey4j.api

import misskey4j.api.request.CreateAppRequest
import misskey4j.api.response.CreateAppResponse
import misskey4j.entity.share.Response

/**
 * App APIs.
 */
interface AppResource {

    /**
     * アプリを作成します。
     * https://misskey.io/api-doc#operation/app/create
     */
    fun createApp(
        request: CreateAppRequest
    ): Response<CreateAppResponse>
}
