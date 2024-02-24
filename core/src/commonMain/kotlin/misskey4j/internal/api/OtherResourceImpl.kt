package misskey4j.internal.api

import misskey4j.MisskeyAPI.ServiceWorkerRegister
import misskey4j.api.OtherResource
import misskey4j.api.request.other.ServiceWorkerRegisterRequest
import misskey4j.api.response.other.ServiceWorkerRegisterResponse
import misskey4j.entity.share.Response

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
