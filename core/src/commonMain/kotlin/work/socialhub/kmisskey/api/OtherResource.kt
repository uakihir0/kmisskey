package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.other.ServiceWorkerRegisterRequest
import work.socialhub.kmisskey.api.response.other.ServiceWorkerRegisterResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface OtherResource {

    /**
     * サービスワーカーの通知先を登録します
     * https://misskey.io/api-doc#operation/sw/register
     */
    suspend fun serviceWorkerRegister(
        request: ServiceWorkerRegisterRequest
    ): Response<ServiceWorkerRegisterResponse>

    fun serviceWorkerRegisterBlocking(
        request: ServiceWorkerRegisterRequest
    ): Response<ServiceWorkerRegisterResponse>
}
