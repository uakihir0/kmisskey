package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.api.FederationResource
import misskey4j.api.request.federation.ShowInstanceRequest
import misskey4j.api.response.federation.FederationInstanceResponse
import misskey4j.entity.share.Response

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
        return post(
            MisskeyAPI.FederationShowInstance.path,
            request
        )
    }
}
