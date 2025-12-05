package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.CreateAppRequest
import work.socialhub.kmisskey.api.response.CreateAppResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

/**
 * App APIs.
 */
@JsExport
interface AppResource {

    /**
     * アプリを作成します。
     * https://misskey.io/api-doc#operation/app/create
     */
    suspend fun createApp(
        request: CreateAppRequest
    ): Response<CreateAppResponse>

    fun createAppBlocking(
        request: CreateAppRequest
    ): Response<CreateAppResponse>
}
