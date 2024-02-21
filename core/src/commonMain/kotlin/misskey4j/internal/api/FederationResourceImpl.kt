package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.entity.share.Response

class FederationResourceImpl(uri: String) : AbstractResourceImpl(uri, null), FederationResource {
    override fun showInstance(request: ShowInstanceRequest): Response<FederationInstanceResponse> {
        return post(FederationInstanceResponse::class.java, MisskeyAPI.FederationShowInstance.code(), request)
    }
}
