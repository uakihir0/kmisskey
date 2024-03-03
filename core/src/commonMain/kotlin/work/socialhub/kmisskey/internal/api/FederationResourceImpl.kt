package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.FederationShowInstance
import work.socialhub.kmisskey.api.FederationResource
import work.socialhub.kmisskey.api.request.federation.ShowInstanceRequest
import work.socialhub.kmisskey.api.response.federation.FederationInstanceResponse
import work.socialhub.kmisskey.entity.share.Response

class FederationResourceImpl(
    uri: String
) : AbstractResourceImpl(uri, ""),
    FederationResource {

    /**
     * {@inheritDoc}
     */
    override fun showInstance(
        request: ShowInstanceRequest
    ): Response<FederationInstanceResponse> {
        return post(FederationShowInstance.path, request)
    }
}
