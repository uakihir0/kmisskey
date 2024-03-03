package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.federation.ShowInstanceRequest
import work.socialhub.kmisskey.api.response.federation.FederationInstanceResponse
import work.socialhub.kmisskey.entity.share.Response

/**
 * Federation APIs.
 */
interface FederationResource {

    fun showInstance(
        request: ShowInstanceRequest
    ): Response<FederationInstanceResponse>
}
