package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.federation.ShowInstanceRequest
import work.socialhub.kmisskey.api.response.federation.FederationInstanceResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

/**
 * Federation APIs.
 */
@JsExport
interface FederationResource {

    suspend fun showInstance(
        request: ShowInstanceRequest
    ): Response<FederationInstanceResponse>

    @JsExport.Ignore
    fun showInstanceBlocking(
        request: ShowInstanceRequest
    ): Response<FederationInstanceResponse>
}
