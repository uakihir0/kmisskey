package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.ServiceWorkerRegister
import work.socialhub.kmisskey.api.OtherResource
import work.socialhub.kmisskey.api.request.other.ServiceWorkerRegisterRequest
import work.socialhub.kmisskey.api.response.other.ServiceWorkerRegisterResponse
import work.socialhub.kmisskey.entity.share.Response

class OtherResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    OtherResource {

    /**
     * {@inheritDoc}
     */
    override fun serviceWorkerRegister(
        request: ServiceWorkerRegisterRequest
    ): Response<ServiceWorkerRegisterResponse> {
        return post(ServiceWorkerRegister.path, request)
    }
}
