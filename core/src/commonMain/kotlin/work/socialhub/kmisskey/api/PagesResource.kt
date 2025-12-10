package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.pages.PagesCreateRequest
import work.socialhub.kmisskey.api.request.pages.PagesDeleteRequest
import work.socialhub.kmisskey.api.request.pages.PagesShowRequest
import work.socialhub.kmisskey.api.request.pages.PagesUpdateRequest
import work.socialhub.kmisskey.entity.Page
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface PagesResource {

    /**
     * ページを作成します。
     * https://misskey.io/api-doc#operation/pages/create
     */
    @JsExport.Ignore
    suspend fun create(
        request: PagesCreateRequest
    ): Response<Page>

    @JsExport.Ignore
    fun createBlocking(
        request: PagesCreateRequest
    ): Response<Page>

    /**
     * ページを削除します。
     * https://misskey.io/api-doc#operation/pages/delete
     */
    @JsExport.Ignore
    suspend fun delete(
        request: PagesDeleteRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun deleteBlocking(
        request: PagesDeleteRequest
    ): EmptyResponse

    /**
     * ページを取得します。
     * https://misskey.io/api-doc#operation/pages/show
     */
    @JsExport.Ignore
    suspend fun show(
        request: PagesShowRequest
    ): Response<Page>

    @JsExport.Ignore
    fun showBlocking(
        request: PagesShowRequest
    ): Response<Page>

    /**
     * ページを更新します。
     * https://misskey.io/api-doc#operation/pages/update
     */
    @JsExport.Ignore
    suspend fun update(
        request: PagesUpdateRequest
    ): Response<Page>

    @JsExport.Ignore
    fun updateBlocking(
        request: PagesUpdateRequest
    ): Response<Page>
}
